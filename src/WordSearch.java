public class WordSearch {
    public static void main(String[] args) {
        char[][] arrays = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(new WordSearch().exist(arrays, word));
    }

    /**
     * TODO time limit error
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length() || "".equals(word)) return false;

        char[] chars = word.toCharArray();
        int maxX = board[0].length, maxY = board.length;
        boolean[][] bl = new boolean[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (board[i][j] == chars[0]) {
                    if (chars.length == 1) return true;
                    for (int m = 0; m < maxY; m++)
                        for (int n = 0; n < maxX; n++)
                            bl[m][n] = true;
                    bl[i][j] = false;

                    if (this.right(board, chars, 1, bl, j, i)) return true;
                }
            }
        }

        return false;
    }

    public boolean right(char[][] board, char[] chr, int index, boolean[][] bl, int x, int y) {
        if (x - 1 >= 0 && bl[y][x-1] && board[y][x-1] == chr[index]) {
            for (int a=0; a<index;a++) System.out.print("\t");
            System.out.print("|--");
            System.out.println("1\t\t["+y+","+(x-1)+"] ");
            if (index == chr.length - 1) return true;
            boolean[][] blc = new boolean[bl.length][bl[0].length];
            for (int m = 0; m < bl.length; m++)
                for (int n = 0; n < bl[0].length; n++)
                    blc[m][n] = bl[m][n];
            blc[y][x-1] = false;
            if (this.right(board, chr, index + 1, blc, x-1, y)) return true;
        }

        if (x + 1 < board[0].length && bl[y][x+1] && board[y][x+1] == chr[index]) {
            for (int a=0; a<index;a++) System.out.print("\t");
            System.out.print("|--");
            System.out.println("2\t\t["+y+","+(x+1)+"] ");
            if (index == chr.length - 1) return true;
            boolean[][] blc = new boolean[bl.length][bl[0].length];
            for (int m = 0; m < bl.length; m++)
                for (int n = 0; n < bl[0].length; n++)
                    blc[m][n] = bl[m][n];
            blc[y][x+1] = false;
            if (this.right(board, chr, index + 1, blc, x+1, y)) return true;
        }

        if (y - 1 >= 0 && bl[y-1][x] && board[y-1][x] == chr[index]) {
            for (int a=0; a<index;a++) System.out.print("\t");
            System.out.print("|--");
            System.out.println("3\t\t["+(y-1)+","+(x)+"] ");
            if (index == chr.length - 1) return true;
            boolean[][] blc = new boolean[bl.length][bl[0].length];
            for (int m = 0; m < bl.length; m++)
                for (int n = 0; n < bl[0].length; n++)
                    blc[m][n] = bl[m][n];
            blc[y-1][x] = false;
            if (this.right(board, chr, index + 1, blc, x, y-1)) return true;
        }

        if (y+1 < board.length && bl[y+1][x] && board[y+1][x] == chr[index]) {
            for (int a=0; a<index;a++) System.out.print("\t");
            System.out.print("|--");
            System.out.println("4\t\t["+(y+1)+","+(x)+"] ");
            if (index == chr.length - 1) return true;
            boolean[][] blc = new boolean[bl.length][bl[0].length];
            for (int m = 0; m < bl.length; m++)
                for (int n = 0; n < bl[0].length; n++)
                    blc[m][n] = bl[m][n];
            blc[y+1][x] = false;
            if (this.right(board, chr, index + 1, blc, x, y+1)) return true;
        }
        System.out.println();
        return false;
    }
}
