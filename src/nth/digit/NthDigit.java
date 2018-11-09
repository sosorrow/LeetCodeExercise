package nth.digit;

public class NthDigit {
    public static void main(String[] args) {
        System.out.print(new NthDigit().findNthDigit(3));
    }

    public int findNthDigit(int n) {
        int i=1, total = 0, num = 0;

        while (total + i * 9 * Math.pow(10, i-1) < n) {
            total += i * 9 * Math.pow(10, i-1);
            num += 9 * Math.pow(10, i-1);
            System.out.print(total + "\t");
            i++;
        }

        System.out.println("total:" + total);
        n -= total;
        System.out.println("n:" + n);
        num += Math.floor(n / i);
        n %= i;
        System.out.println("num:" + num);
        System.out.println("n:" + n);
        System.out.println("total:" + total);
        if (n == 0) return num % 10;
        return Integer.parseInt(String.valueOf(String.valueOf(num + 1).charAt(n - 1)));
    }
}
