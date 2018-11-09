public class ImageSmoother {
    public static void main(String[] args){
        int[][] arrays = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        for (int i=0; i<arrays.length; i++) {
            for (int j=0; j<arrays[0].length; j++) {
                System.out.print("\t" + arrays[i][j]);
            }
            System.out.println();
        }
        arrays = new ImageSmoother().imageSmoother(arrays);
        for (int i=0; i<arrays.length; i++) {
            for (int j=0; j<arrays[0].length; j++) {
                System.out.print("\t" + arrays[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] imageSmoother(int[][] M) {
        int sum, total, maxX = M[0].length, maxY = M.length;
        int[][] result = new int[maxY][maxX];
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[0].length; j++) {
                sum=0;
                total=0;
                for (int m=-1;m <= 1;m++) {
                    for (int n=-1; n<=1; n++) {
                        if (i+m < 0 || i+m >= maxY || j+n <0 || j+n >= maxX) continue;
                        sum += M[i+m][j+n];
                        total++;
                    }
                }

                result[i][j] = (int) Math.floor((sum / total));
            }
            System.out.println();
        }

        return result;
    }
}
