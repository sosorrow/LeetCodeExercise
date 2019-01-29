package string;

import java.util.Arrays;

public class MinimumSubstring {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "adobecodebanc", t = "abcda";
        String s = "ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", t = "ask_country";
        // 2  3

        // 0  1

        // 2  3

        // 0 2      1 2     0 3      1 3
        // 2 3
        // 0 2   0 3    12 13   03 03  13 13
        System.out.print(new MinimumSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if ("".equals(s) || "".equals(t)) return "";
        int start = -1, end = -1, min = Integer.MAX_VALUE, tl = t.length();
        int[][] ca = {};
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        for (int i = 0; i < tcs.length; i++) {
            int[] cs = {};
            for (int j = 0; j < scs.length; j++) {
                if (tcs[i] == scs[j]) {
                    cs = Arrays.copyOf(cs, cs.length + 1);
                    cs[cs.length - 1] = j;
                }
            }
            System.out.print(tcs[i] + " > ");
            for (int a : cs) {
                System.out.print(a + " ");
            }
            System.out.println();
            if (cs.length == 0) return "";
            else {
//                if (ca.length == 0) {
//                    for (int a = 0; a < cs.length; a++) {
//                        int[] d = new int[1];
//                        d[0] = cs[a];
//                        ca = Arrays.copyOf(ca, ca.length + 1);
//                        ca[ca.length - 1] = d;
//                    }
//                } else {
//                    int[][] nca = {};
//
//                    for (int a = 0; a < cs.length; a++) {
//                        for (int b = 0; b < ca.length; b++) {
//                            boolean contains = false;
//                            for (int c = 0; c < ca[b].length; c++) {
//                                if (cs[a] == ca[b][c]) contains = true;
//                            }
//                            if (contains) continue;
//                            else {
//                                nca = Arrays.copyOf(nca, nca.length + 1);
//                                nca[nca.length - 1] = Arrays.copyOf(ca[b], ca[b].length + 1);
//                                nca[nca.length - 1][ca[b].length] = cs[a];
//                            }
//                        }
//                    }
//                    ca = nca;
//                }
            }
        }
        for (int[] c : ca) {
            Arrays.sort(c);
            if (min > c[c.length - 1] - c[0] && (c[c.length - 1] - c[0] + 1) >= t.length()) {
                min = c[c.length - 1] - c[0];
                start = c[0];
                end = c[c.length - 1] + 1;
            }
        }
        if (start == -1 || end == -1) return "";
        return s.substring(start, end);
    }
}
