package rectangle;

import java.util.HashSet;
import java.util.Iterator;

public class PerfectRectangle {
    public static void main(String[] args) {
        int[][] s = {{0,0,4,1},{7,0,8,2},{5,1,6,3},{6,0,7,2},{4,0,5,1},{4,2,5,3},{2,1,4,3},{-1,2,2,3},{0,1,2,2},{6,2,8,3},{5,0,6,1},{4,1,5,2}};

        System.out.print(new PerfectRectangle().isRectangleCover1(s));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) return false;

        int minX = Integer.MIN_VALUE, minY = Integer.MIN_VALUE, maxX = Integer.MAX_VALUE, maxY = Integer.MAX_VALUE;
        for (int[] point: rectangles) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[2]);
            minY = Math.min(minY, point[1]);
            maxY = Math.max(maxY, point[3]);
        }

        int[][] arr = new int[maxY - minY][maxX - minX];
        System.out.println("minX:" + minX);
        System.out.println("maxX:" + maxX);
        System.out.println("minY:" + minY);
        System.out.println("maxY:" + maxY);
        for (int[] point: rectangles) {
            for (int j=point[1]-minY; j<point[3]-minY; j++) {
                for (int i=point[0]-minX; i<point[2]-minX; i++) {
                    System.out.print(j + "," + i + "\t");
                    if (arr[j][i] == 1) return false;
                    arr[j][i] = 1;
                }
                System.out.println();
            }
        }

        for (int[] a : arr) {
            for (int b: a) {
                System.out.print(b + "\t");
                if (b == 0) return false;
            }
            System.out.println();
        }

        return true;
    }

    public boolean isRectangleCover1(int[][] rectangles) {

        if (rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<String>();
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String s1 = rect[0] + " " + rect[1];//  x0  y0
            String s2 = rect[0] + " " + rect[3];//  x0  x1
            String s3 = rect[2] + " " + rect[3];//  x1  y1
            String s4 = rect[2] + " " + rect[1];//  x1  y0

            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);

            Iterator<String> s = set.iterator();
            while (s.hasNext()) {
                System.out.print(s.next() + "\t\t");
            }
            System.out.println();
        }

        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;

        return area == (x2-x1) * (y2-y1);
    }
}
