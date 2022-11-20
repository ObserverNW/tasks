package task1;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println( twoElements(n, m));
    }
    static String twoElements (int n, int m){
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int index = 0;
        boolean indexIsNotNull = false;
        String result = "";
        while (!indexIsNotNull) {
            result += String.valueOf (nums[index]);
            index = (index + m-1) % nums.length;
            if (index == 0){
                indexIsNotNull = true;
            }
        }
        return result;
    }
}