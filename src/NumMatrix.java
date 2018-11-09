public class NumMatrix {
    public static void main(String args[]) {
        int[][] arrays = {{-4, -5}};
        NumMatrix numMatrix = new NumMatrix(arrays);
        System.out.print(numMatrix.sumRegion(0, 0, 0, 0));
    }

    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) return -1;
        int sum = 0;
        for (; row1 <= row2; row1++) {
            for (int j = col1; j <= col2; j++) {
                sum += this.matrix[row1][j];
            }
        }
        return sum;
    }

    //  [
    //      [
    //          [
    //              [-4,-5]
    //          ]
    //      ],
    //      [0,0,0,0],
    //      [0,0,0,1],
    //      [0,1,0,1]
    //  ]
}
