package matrix;

public class FlippingMatrix {
    public static void main(String[] args) {
        int[][] a = {};

        //  0 0 1 1    0 0 1 1    0 1 1 1    0 1 1 1    1 1 1 1
        //  1 0 1 0    1 0 1 0    1 1 1 0    0 0 0 1    1 0 0 1
        //  1 1 0 0    0 0 1 1    0 1 1 1    0 1 1 1    1 1 1 1

        //  1 1 0 0    1 1 0 1
        //  1 0 1 0    1 0 1 1
        //  1 1 0 0    1 1 0 1

        System.out.print(new FlippingMatrix().matrixScore(a));
    }

    public int matrixScore(int[][] A) {
        return 0;
    }
}
