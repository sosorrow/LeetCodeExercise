package assign;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,4,5,2,4,6,2,3,2,5}, s = {2,4,5,5,5,6,1};
        System.out.print(new AssignCookies().findContentChildren(g ,s));
    }

    public int findContentChildren(int[] g, int[] s) {
        int result = 0, i = 0, j = 0;
        if (g.length == 0 || s.length == 0) return result;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                j++;
                continue;
            }
            result++;
            i++;
            j++;
        }

        return result;
    }
}
