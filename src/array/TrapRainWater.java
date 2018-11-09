package array;

import java.util.Arrays;

public class TrapRainWater {
    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        //{1,9,7,1,3,6,4,7,4,8,3,6,3,5,3,7};
        //{4,3,8,3,1,5,9,9,0,4,3,4,7};
        //{2,8,5,5,6,1,7,4,5};
        //{5,2,1,2,1,5};
        //{6,7,6,3,5,7,1,4,2,0,5,8,2,9,5,1,3,1,0};
        //{0,4,7,0,0,4,5,6,7,4,7};
        //{1,4,3,4,0,0,2,6,0,8,9,4,5,6,5,2,6,7};
        //{8,9,3,6,9,6,8,0,7,6,8,1};
        //{5,5,1,7,1,1,5,2,7,6};
        // {7,5,6,1,9,8,9,8,7,3};
        //{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        for (int m : a) System.out.print(m + " ");
        System.out.println();
        System.out.print(new TrapRainWater().trap(a));
    }

    //                                9
    //                             8
    //                                                      7
    //                       6                 6        6
    //                                      5     5
    //     4     4                       4
    //        3
    //                    2                          2
    //  1
    //              0  0        0
    //  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17


    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int r = 0, i = 2, max = 0, smax = 1;

        if (height[0] < height[1]) {
            max = 1;
            smax = 0;
        }

        while (i < height.length) {
            if (height[i] >= height[max]) {
                smax = max;
                max = i;
            } else if (height[i] > height[smax]) smax = i;
            i++;
        }

        if (Math.abs(smax - max) > 1) {
            int min = Math.min(height[smax], height[max]);
            r = Math.abs(smax - max) * min;
            for (int j = Math.min(smax, max); j < Math.max(smax, max); j++) {
                r -= Math.min(min, height[j]);
            }
            r += trap(Arrays.copyOfRange(height, 0, Math.min(smax, max) + 1));
        }
        r += trap(Arrays.copyOfRange(height, Math.max(smax, max), height.length));

        return r;
    }


    public int trap1(int[] height) {
        int r = 0, i = 0, left = -1;
        if (height.length > 0) {
            int[] top = new int[0];
            while (i < height.length) {
                if ((i == height.length - 1 || height[i + 1] <= height[i]) && (i == 0 || height[i - 1] < height[i])) {
                    top = Arrays.copyOf(top, top.length + 1);
                    top[top.length - 1] = i;
                }
                i++;
            }
            if (top.length > 2) top = checkTop(height, top);
            for (int j = 0; j < top.length - 1; j++) {
                int min = Math.min(height[top[j]], height[top[j + 1]]);
                int sum = (top[j + 1] - top[j]) * min;
                for (int m = top[j]; m < top[j + 1]; m++) {
                    sum -= Math.min(min, height[m]);
                }
                r += sum;
            }
        }
        return r;
    }

    public int[] checkTop(int[] height, int[] arr) {
        int[] top = new int[0], r = new int[0];
        int i = 2, left = 0, right = 1;
        for (int m : arr) System.out.print(m + "\t");
        System.out.println();
        for (int m : arr) System.out.print(height[m] + "\t");
        System.out.println();

        if (height[arr[right]] >= height[arr[left]]) {
            top = Arrays.copyOf(top, top.length + 1);
            top[top.length - 1] = arr[left];
            left = right;
        }
        while (i < arr.length) {
            if (height[arr[i]] >= height[arr[left]]) {
                top = Arrays.copyOf(top, top.length + 1);
                top[top.length - 1] = arr[left];
                left = right = i;
            } else if (left == right || height[arr[i]] >= height[arr[right]]) {
                right = i;
            } else if (height[arr[i - 1]] < height[arr[i]] && (i <= arr.length - 1 || height[arr[i + 1]] < height[arr[i]])) {
                top = Arrays.copyOf(top, top.length + 1);
                top[top.length - 1] = arr[right];
                right = i;
            }
            i++;
        }
        top = Arrays.copyOf(top, top.length + 1);
        top[top.length - 1] = arr[left];
        if (right > left) {
            top = Arrays.copyOf(top, top.length + 1);
            top[top.length - 1] = arr[right];
        }

        System.out.print("top: ");
        for (int m : top) System.out.print(m + " ");
        System.out.println();

        if (top.length <= 1) return arr;

        i = 0;
        while (i < arr.length) {
            if (arr[i] < top[0] || arr[i] > top[top.length - 1]) {
                r = Arrays.copyOf(r, r.length + 1);
                r[r.length - 1] = arr[i];
            } else if (arr[i] == top[0]) {
                r = Arrays.copyOf(r, r.length + top.length);
                for (int j = 0; j < top.length; j++) r[r.length - top.length + j] = top[j];
            }
            i++;
        }

        System.out.print("r: ");
        for (int m : r) System.out.print(m + " ");
        System.out.println();

        return r;
    }

    public int trapTimeOutLimit(int[] height) {
        int r = 0, i = 0;
        while (i < height.length) {
            if (i > 0) {
                if (height[i] > height[i - 1]) {
                    int j = i - 1;
                    while (j > 0 && height[j - 1] >= height[j]) {
                        if (height[j - 1] > height[i - 1]) {
                            int min = Math.min(height[j - 1], height[i]);
                            r += (min - height[i - 1]) * (i - j);
                            for (int l = j; l < i; l++) {
                                if (height[l] < min) height[l] = min;
                            }
                        }
                        j--;
                    }
                }
            }
            i++;
        }
        for (int k: height) System.out.print(k + " ");
        return r;
    }
}
