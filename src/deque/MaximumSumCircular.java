package deque;

public class MaximumSumCircular {
    public static void main(String[] args) {
        int[] a = {};

        System.out.println(new MaximumSumCircular().maxSubarraySumCircular(a));
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];
        if (A.length == 2) return Math.max(A[0] + A[1], Math.max(A[0], A[1]));
        int start = 0, end = 0, sum = Integer.MIN_VALUE;


        return 0;
    }
}
