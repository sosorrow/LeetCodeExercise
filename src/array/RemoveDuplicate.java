package array;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] a = {0, 0 , 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new RemoveDuplicate().removeDuplicates(a));
        for (int n : a) {
            System.out.print(n + "  ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1, count = 1, cur = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == cur) {
                if (count < 2) {
                    count++;
                    nums[index++] = nums[i];
                } else continue;
            } else {
                cur = nums[i];
                count = 1;
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
