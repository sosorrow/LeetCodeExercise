public class Sqrt {
    public static void main(String[] args) {
        System.out.print(new Sqrt().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int m = 1, n = 1, temp;
        double temp2;
        while (m <= n) {
            m *= 2;
            n = x / m;
            System.out.println(m + "  <-->  " + n);
        }
        n = m;
        m /= 2;
        System.out.println("=====================================");
        while (m < n - 1) {
            temp = (m + n) / 2;
            temp2 = (double) temp * (double) temp;
            if (temp2 > Integer.MAX_VALUE || temp2 > x) {
                n = temp;
            } else if (temp2 < x) {
                m = temp;
            } else if (temp2 == x) {
                return temp;
            }
            System.out.println(temp + "  <-->  " + m + "  <-->  " + n);
        }

        return m;
    }
}
