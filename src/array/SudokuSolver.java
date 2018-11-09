package array;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {

//        char[][] c = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] c = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new SudokuSolver().solveSudoku(c);
    }

    char[][] r;
    public void solveSudoku(char[][] board) {
        int dir = 0, gap = -1, max = 0, countX = 0, countY = 0;

        for (int i = 0; i < 9; i++) {
            countX = countY = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') countX++;
                if (board[j][i] != '.') countY++;
            }
            if (countX > max || countY > max) {
                dir = countX > countY ? 0 : 1;
                gap = i;
                max = Math.max(countX, countY);
            }
        }

        boolean re = fill(dir, gap, board);
        if (re) copyArray(r, board);
    }

    public boolean fill(int dir, int gap, char[][] board) {
        int num, x, y;
        String s = "123456789";// 候选数字
        StringBuffer sb = new StringBuffer();// 下标位置
        for (int i = 0; i < 9; i++) {
            if (dir == 0 && board[gap][i] != '.') s = s.replace(String.valueOf(board[gap][i]), "");
            else if (dir == 1 && board[i][gap] != '.') s = s.replace(String.valueOf(board[i][gap]), "");
            else sb.append(i);
        }

        int index = 0;
        String[] allow = new String[sb.length()];
        for (char n : sb.toString().toCharArray()) {
            num = n - '0';
            String ss = s;

            for (int i = 0; i < 9; i++) {
                if (dir == 0) {
                    x = (gap / 3) * 3 + i / 3;
                    y = (num / 3) * 3 + i % 3;
                    if (board[i][num] != '.') ss = ss.replace(String.valueOf(board[i][num]), "");
                } else {
                    x = (num / 3) * 3 + i / 3;
                    y = (gap / 3) * 3 + i % 3;
                    if (board[num][i] != '.') ss = ss.replace(String.valueOf(board[num][i]), "");
                }
                if (board[x][y] != '.') ss = ss.replace(String.valueOf(board[x][y]), "");
            }
            if ("".equals(ss)) return false;
            allow[index] = ss;
            index++;
        }

        int count = 0, g = -1, max = 0;
        for (String m : merge(allow)) {
            char[][] array = new char[9][9];
            copyArray(board, array);
            int i = 0;
            for (char c : sb.toString().toCharArray()) {
                if (dir == 0) array[gap][c - '0'] = m.charAt(i);
                else array[c - '0'][gap] = m.charAt(i);
                i++;
            }

            for (i = 0; i < 9; i++) {
                count = 0;
                for (int j = 0; j < 9; j++) {
                    if (dir == 0 && array[j][i] != '.') count++;
                    else if (dir == 1 && array[i][j] != '.') count++;
                }

                if (count >= 9) continue;
                if (count > 0 && count > max) {
                    max = count;
                    g = i;
                }
            }
            if (g == -1) {
                r = array;
                return true;
            }
            if (fill(1 - dir, g, array)) return true;
        }

        return false;
    }

    public String[] merge(String[] array) {
        if (array.length == 1) {
            String[] r = new String[array[0].length()];
            char[] chrs = array[0].toCharArray();
            for (int i = 0; i < chrs.length; i++) {
                r[i] = String.valueOf(chrs[i]);
            }
            return r;
        }
        String[] a = merge(Arrays.copyOfRange(array, 1, array.length));
        String[] r = new String[0];
        String s = array[0];
        for (int i = 0; i < s.length() * a.length; i++) {
            if (a[i % a.length] == null || a[i % a.length].contains(s.substring(i / a.length, i / a.length + 1))) continue;
            r = Arrays.copyOf(r, r.length + 1);
            r[r.length - 1] = s.substring(i / a.length, i / a.length + 1) + a[i % a.length];
        }
        return r;
    }

    public void copyArray(char[][] b, char[][] r) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) r[i][j] = b[i][j];
        }
    }
}
