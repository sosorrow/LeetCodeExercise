package array;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] a = {3, 4, -1, 1};
        System.out.print(new FirstMissingPositive().firstMissingPositive(a));
    }

    public int firstMissingPositive(int[] nums) {
        int r = 0, i = 0;
        if (nums.length > 0) {

        }
        return r + 1;
    }

    public int firstMissingPositiveWithSort(int[] nums) {
        int r = 0, i = 0;
        if (nums.length > 0) {
            Arrays.sort(nums);
            while (i < nums.length) {
                if (nums[i] > 0) {
                    if (nums[i] == r + 1) r++;
                    else if (nums[i] > r + 1) return r + 1;
                }
                i++;
            }
        }
        return r + 1;
    }
}