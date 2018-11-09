package string;

import java.util.Arrays;
import java.util.Date;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(new WildcardMatching().isMatch("aa", "*"));
        System.out.println(new Date().getTime());
    }

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) return true;
        if ("".equals(p)) return false;
        String[] arr = split(p, '*');
        for (String a : arr) {
            if (!p.startsWith("*") && !s.startsWith(a)) return false;
        }

        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                do {
                    j++;
                } while (j < p.length() && p.charAt(j) == '*');
                for (int m = i; m <= s.length(); m++) {
                    if (isMatch(s.substring(m, s.length()), p.substring(j, p.length()))) return true;
                }
            } else {
                return false;
            }
        }
        s = s.substring(i, s.length());
        p = p.substring(j, p.length());
        if ("".equals(s)) {
            for (char c : p.toCharArray()) {
                if (c != '*') return false;
            }
            return true;
        }
        if (i == s.length() && j == p.length()) return true;
        return false;
    }

    public String[] split(String s, char c) {
        String[] r = new String[0];
        StringBuffer sb = new StringBuffer();
        for (char a : s.toCharArray()) {
            if (a != c) {
                sb.append(a);
            } else {
                if (!"".equals(sb.toString())) {
                    r = Arrays.copyOf(r, r.length + 1);
                    r[r.length - 1] = sb.toString();
                    sb.delete(0, sb.length());
                }
            }
        }
        return r;
    }
}
