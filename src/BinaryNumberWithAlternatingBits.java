public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        System.out.print(new BinaryNumberWithAlternatingBits().hasAlternatingBits(6));
    }

    private int n;
    public boolean hasAlternatingBits(int n) {
        if (n >= Integer.MAX_VALUE) return false;
        this.n = n;
        int[] binaryArray = new int[32];
        int max = 0, m = 0;

        while (this.n > 1) {
            m = x2(1);
            if (max == 0) max = m;
            binaryArray[31 - m] = 1;
        }
        if (this.n == 1) binaryArray[31] = 1;
        for (int i=0; i<32; i++) System.out.print(binaryArray[i]);
        System.out.println();
        for (int i=31 - max; i<31; i++) {
            if (binaryArray[i] == binaryArray[i+1]) return false;
        }

        return true;
    }

    private int x2(int num) {
        if (num > Integer.MAX_VALUE / 2 || num*2 > this.n) {
            this.n -= num;
            return 0;
        } else {
            return 1 + x2(num * 2);
        }
    }
}
