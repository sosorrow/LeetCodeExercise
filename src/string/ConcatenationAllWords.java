package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenationAllWords {
    public static void main(String[] args) {
        String[] a = {"cc", "bb"};

        for (Integer i: new ConcatenationAllWords().findSubstring("bcccbbbcba", a)) {
            System.out.print(i + "  ");
        }
    }



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> r = new ArrayList<>();
        if ("".equals(s) || words.length == 0) return r;
        if (s.length() < words.length * words[0].length()) return r;
        int size = words[0].length(), l = words.length, t = size * l, min, max;
        List<Integer> arr = new ArrayList<>();
        for (String flag : words) {
            for (int n : indexOfAll(s, flag)) {
                if (!arr.contains(n)) arr.add(n);
            }
        }
        if (l == 1) return arr;

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                System.out.println(arr.get(i) + " -- " + arr.get(j));
                if (Math.abs(arr.get(i) - arr.get(j)) + size == t) {
                    min = Math.min(arr.get(i), arr.get(j));
                    max = Math.max(arr.get(i), arr.get(j));
                    if (compare(s.substring(min, max + size), words)) {
                        if (!r.contains(min)) r.add(min);
                    }
                }
            }
        }
        return r;
    }

    public boolean compare(String s, String[] flag) {
        int l = flag[0].length();
        boolean[] c = new boolean[flag.length];
        Arrays.fill(c, true);
        while (s.length() > 0) {
            for (int m = 0; m < flag.length; m++) {
                if (c[m] && s.substring(0, l).equals(flag[m])) {
                    c[m] = false;
                    s = s.substring(l, s.length());
                    break;
                }
                if (m == flag.length - 1) return false;
            }
        }
        return true;
    }

    public List<Integer> indexOfAll(String s, String flag) {
        List<Integer> r = new ArrayList<>();
        int i = s.indexOf(flag), p = 0;
        while (i >= 0) {
            r.add(i + p);
            s = s.substring(0, i).concat(s.substring(i + 1, s.length()));
            p++;
            i = s.indexOf(flag);
        }
        return r;
    }
}
