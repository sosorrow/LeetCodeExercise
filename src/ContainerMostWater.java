public class ContainerMostWater {
    /**
     * not finish
     * @param args
     */
    public static void main(String args[]) {
        System.out.print(new ContainerMostWater().maxArea(new int[]{2, 1}));
    }

    public int maxArea(int[] height) {
        int area = 0, len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == j) continue;
                System.out.println(i + " --- " + j);
                System.out.println(height[i] + " --- " + height[j]);
                System.out.println(Math.abs((i - j) * 1.0));
                System.out.println(height[i]);
                if (area < Math.abs((i - j) * 1.0) * Math.min(height[i], height[j])) {
                    area = (int) Math.abs((i - j) * 1.0) * Math.min(height[i], height[j]);
                }
            }
        }
        return area;
    }
}
