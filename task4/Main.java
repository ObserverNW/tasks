package task4;
import java.nio.file.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
public class Main {
    static int cLine;
    public static void main(String[] args) throws IOException {
        String firstWay = args[0];

        List<String> lines = Files.readAllLines(new File(firstWay).toPath());
        cLine =  lines.size();

        int[] nums = readFile(firstWay);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        int mid = nums.length / 2;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Math.abs(nums[i] - nums[mid]);
        }
        System.out.println(result);
    }
    public static int[] readFile(String firstWay) {
        String[] ex = new String[cLine];
        int[] nums1 = new int[cLine];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(firstWay));
            String line;
            int q = 0;
            while ((line = br.readLine()) != null) {
                ex[q++] = line;
                }
            br.close();
            for (int i = 0; i < ex.length; i++) {
                nums1[i] = Integer.parseInt(ex[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nums1;
    }
}