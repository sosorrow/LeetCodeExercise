public class RegularExpressingMatch {
    public static void main(String[] args) {
        System.out.println(new RegularExpressingMatch().isMatch("adasd", ".*a"));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return false;
        if (p.startsWith("*")) return false;
        if (s.isEmpty() && !"*".equals(p)) return false;

        int i = 0, j = 0;
        while (true) {
            if (i >= s.length() && j >= p.length()) return true;
            else if (i >= s.length() || j >= p.length()) return false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                i--;
                j--;

            } else {
                return false;
            }
        }
    }
}
