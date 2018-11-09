package array;

public class JumpGame {

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.print(new JumpGame().jump(a));
    }

    public int jump(int[] nums) {
        int r = 0, i = 0, max, maxI = 0;
        while (i < nums.length - 1) {
            max = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    r++;
                    return r;
                } else if (nums[i + j] + j > max) {
                    max = nums[i + j] + j;
                    maxI = i + j;
                }
            }
            i = maxI;
            System.out.print(i + "  ");
            r++;
        }
        return r;
    }
}
