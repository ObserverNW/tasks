package task2;
import java.nio.file.*;
import java.io.*;
import java.util.List;
public class Main {
    static int cLine;
    public static void main(String[] args) throws IOException {
       if(args.length  < 2) throw new RuntimeException("Обязательно 2 аргумента (пути к файлу)");
        String firstWay = args[0];
        String secondWay = args[1];

        List<String> lines = Files.readAllLines(new File(secondWay).toPath());
        cLine =  lines.size();

        String[] ex = readCircleCoordinate(firstWay);
        float[] coord = new float[ex.length];
        for (int i = 0; i < ex.length; i++) {
            coord[i] = Float.parseFloat(ex[i]);
        }
        float x = coord[0];
        float y = coord[1];
        float r = coord[2];
        float x1 = 0;
        float y1 = 0;

        var points = readPointsCoordinate(secondWay);
        float[][] coord2 = new float[cLine][2];
        for (int i = 0; i < cLine; i++) {
            for (int w = 0; w < 2; w++) {
                coord2[i][w] = Float.parseFloat(points[i][w]);
            }
        }
        for (int i = 0; i < coord2.length; i++) {
            x1 = coord2[i][0]  - x;
            y1 = coord2[i][1] - y;

            float hyp = (float) Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
            if (hyp < r) {
                System.out.println("точка внутри");
            } else if (hyp == r) {
                System.out.println("точка лежит на окружности");
            } else {
                System.out.println("точка снаружи");
            }
        }
    }
    public static String[] readCircleCoordinate(String firstWay) {
        if (firstWay == null) {
            throw new RuntimeException("Отсутствие аргумента");
        }
        if (Files.notExists(Path.of(firstWay))) {
            throw new RuntimeException("Неверный путь");
        }
        BufferedReader br = null;
        String[] ex = null;
        try {
            br = new BufferedReader(new FileReader(firstWay));
            String line, result = "";
            while ((line = br.readLine()) != null) {
                result += line + " ";
            }
            ex = result.split(" ");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ex;
    }
    public static String[][] readPointsCoordinate(String secondWay) throws IOException {
        String[] ex1 = null;
        String[][] ex2 = new String[cLine][2];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(secondWay));
            String line;
            int t = 0;
            while ((line = br.readLine()) != null) {
                ex1 = line.split(" ");
                ex2[t++] = ex1;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ex2;
    }
}