package task2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Первый путь: ");
        String firstWay = scanner.nextLine();
        System.out.println("Второй путь: ");
        String secondWay = scanner.nextLine();

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

        String[][] points = readPointsCoordinate(secondWay);
        int CountLine = CountLine(secondWay);
        float[][] coord2 = new float[CountLine][2];
        for (int i = 0; i < CountLine; i++) {
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
                System.out.println(" точка лежит на окружности");
            } else {
                System.out.println("точка снаружи");
            }
        }
    }

    public static String[] readCircleCoordinate(String firstWay) {
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
    public static int CountLine(String secondWay) {
        BufferedReader br = null;
        int q = 0;
        try {
            br = new BufferedReader(new FileReader(secondWay));
            String line;
            while ((line = br.readLine()) != null) {
                q++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return q;
    }
    public static String[][] readPointsCoordinate(String secondWay) {
        String[] ex1 = null;
        String[][] ex2 = new String[CountLine(secondWay)][2];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(secondWay));
            String line, result = "";
            int q = 0;
            int t = 0;
            while ((line = br.readLine()) != null) {
                ex1 = line.split(" ");
                ex2[t] = ex1;
                t++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ex2;
    }
}