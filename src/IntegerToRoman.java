public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(58));
    }
    //                                1    5    10   50   100  500  1000
    public String[] ss = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman(int num) {
        if (num > 3999) return "";
        return check(num, 0);
    }

    public String check(int num, int s) {
        if (num == 0) return "";
        String re = "";
        int x = num % 10;
        switch (x) {
            case 4:
                re = ss[s] + ss[s + 1];
                break;
            case 5:
                re = ss[s + 1];
                break;
            case 9:
                re = ss[s] + ss[s + 2];
                break;
            default:
                if (x > 5) {
                    x -= 5;
                    re = ss[s + 1];
                }
                while (x > 0) {
                    re = re.concat(ss[s]);
                    x--;
                }
                break;
        }
        return check(num / 10, s += 2) + re;
    }
}
