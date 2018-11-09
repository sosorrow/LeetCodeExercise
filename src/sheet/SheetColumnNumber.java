package sheet;

public class SheetColumnNumber {
    public static void main(String[] args) {
        System.out.print(new SheetColumnNumber().titleToNumber("zy"));
    }

    public int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        s = s.toLowerCase();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 26 + (c - 96);
        }

        return sum;
    }
}
