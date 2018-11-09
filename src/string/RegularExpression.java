package string;

public class RegularExpression {
    public static void main(String[] args) {
//        System.out.print(new RegularExpression().isMatch("mississippi", "mis*is*p*."));
        System.out.print(new RegularExpression().isMatch("bccbbabcaccacbcacaa", ".*b.*c*.*.*.c*a*.c"));
    }

    public boolean isMatch(String s, String p) {
        if (".*".equals(p)) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.') {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    j+=2;
                    if (j < p.length()) {
                        for (int k=i; k<s.length(); k++) {
                            if (isMatch(s.substring(k, s.length()), p.substring(j, p.length()))) return true;
                        }
                    } else return true;
                } else {
                    i++;
                    j++;
                }
            } else if (p.charAt(j) == '*') {
                if (j > 0) {
                    j++;
                    if (j < p.length()) {
                        for (int k=i; k<s.length(); k++) {
                            if (k > i && s.charAt(k - 1) != p.charAt(j - 2)) break;
                            if (isMatch(s.substring(k, s.length()), p.substring(j, p.length()))) return true;
                        }
                    } else {
                        for (int k=i; k<s.length(); k++) {
                            if (s.charAt(k) != p.charAt(j - 2)) return false;
                            else i++;
                        }
                    }
                } else j++;
            } else {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    j++;
                } else if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else return false;
            }
        }

        if (j < p.length()) {
            if ((p.length() - j) % 2 != 0) return false;
            else {
                while (j < p.length()) {
                    if (!p.substring(j, j+2).endsWith("*")) return false;
                    j+=2;
                }
            }
        }
        if (i == s.length() && j == p.length()) return true;

        return false;
    }
}
