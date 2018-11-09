public class LongestCommonPrefix {
    public static void main(String args[]) {
        System.out.print(new LongestCommonPrefix().longestCommonPrefix(new String[]{"fly", "flower", "flow"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String re = "";
        int i = 0, max = 0;
        for (String s : strs) {
            if ("".equals(s)) return re;
            if (max > s.length() || max == 0) max = s.length();
        }
        char c;
        while (i >= 0) {
            if (i >= max) break;
            c = strs[0].charAt(i);
            for (String s: strs) {
                if (s.charAt(i) != c) {
                    return re;
                }
            }
            re += strs[0].charAt(i);
            i++;
        }
        return re;
    }
}
