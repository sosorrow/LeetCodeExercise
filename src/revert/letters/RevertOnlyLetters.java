package revert.letters;

public class RevertOnlyLetters {
    public static void main(String[] args) {
        System.out.print(new RevertOnlyLetters().reverseOnlyLetters("ab-cd"));
    }

    public String reverseOnlyLetters(String S) {
        if (S.length() <= 1) return S;
        int i = 0, j = S.length() - 1;
        String before = "", after = "";
        while (i < j) {
            if (S.charAt(i) < 65 || (S.charAt(i) > 90 && S.charAt(i) < 97) || S.charAt(i) > 122) {
                before += String.valueOf(S.charAt(i++));
                continue;
            }
            if (S.charAt(j) < 65 || (S.charAt(j) > 90 && S.charAt(j) < 97) || S.charAt(j) > 122) {
                after = S.charAt(j--) + after;
                continue;
            }
            before += String.valueOf(S.charAt(j--));
            after = S.charAt(i++) + after;
        }
        return before + (i == j ? S.charAt(i) : "") + after;
    }
}
