package task4;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 90};
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
            System.out.println(result);
        }
    }
}
