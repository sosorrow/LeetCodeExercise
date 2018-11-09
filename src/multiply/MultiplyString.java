package multiply;

import java.text.NumberFormat;

public class MultiplyString {
    public static void main(String[] args) {
        System.out.print(new MultiplyString().multiply("123456789", "987654321"));
    }

    public String multiply(String num1, String num2) {
        if ("".equals(num1) || "".equals(num2)) return "";
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        String strs = "0123456789";

        Double n1, n2;
        Double[] arrs = new Double[num1.length()];
        for (int i=0; i<num1.length(); i++) {
            n2 = 0.0;
            for (int j=0; j<num2.length(); j++) {
                n2 = n2 * 10.0 + strs.indexOf(num2.charAt(j));
            }
            n1 = strs.indexOf(num1.charAt(i)) * 1.0;
            arrs[i] = (i > 0 ? arrs[i - 1] * 10.0 : 0) + n1 * n2;
        }

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(arrs[num1.length() - 1]);
    }
}
