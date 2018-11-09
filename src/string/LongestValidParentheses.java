package string;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()"));
    }

    public int longestValidParentheses(String s) {
        if ("".equals(s)) return 0;
        int i = -1, max = 0;
        char[] chrs = s.toCharArray();
        for (int j = 0; j < chrs.length; j++) {
            if (chrs[j] == '(') i = j;
            else {
                if (i >= 0) {
                    chrs[i] = '1';
                    chrs[j] = '1';
                    while (i >= 0 && chrs[i] != '(') {
                        i--;
                    }
                }
            }
        }

        i = 0;
        for (char c : chrs) {
            System.out.print(c + " ");
            if (c == '1') i++;
            else {
                max = Math.max(i, max);
                i = 0;
            }
        }
        max = Math.max(i, max);

        return max;
    }
}
