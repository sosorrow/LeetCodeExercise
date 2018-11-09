package robot;

public class WalkingRobot {

    public static void main(String[] args) {
        int[] commands = {1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7};
        int[][] obstacles = {{1,5},{-5,-5},{0,4},{-1,-1},{4,5},{-5,-3},{-2,1},{-2,-5},{0,5},{0,-1}};
        System.out.print(new WalkingRobot().robotSim(commands, obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands.length == 0) return 0;
        int type = 1, dir = 1, d, result = 0;
        int[] point = {0, 0}, check;

        for (int i : commands) {
            d = type + dir;
            switch (i) {
                case -2:
                    type = 1 - type;
                    if (d == 0) dir = 1;
                    if (d == 2) dir = -1;
                    break;
                case -1:
                    type = 1 - type;
                    if (d == -1) dir = 1;
                    if (d == 1) dir = -1;
                    break;
                default:
                    check = null;
                    for (int[] p: obstacles) {
                        if (type == 0 && p[1] == point[1]) {
                            if (dir == -1 ? ((check == null || check[0] < p[0]) && p[0] < point[0]) : ((check == null || check[0] > p[0]) && p[0] > point[0])) check = p;
                        } else if (type == 1 && p[0] == point[0]) {
                            if (dir == -1 ? ((check == null || check[1] < p[1]) && p[1] < point[1]) : ((check == null || check[1] > p[1]) && p[1] > point[1])) check = p;
                        }
                    }

                    d = point[type] + dir * i;
                    if (check != null && (type == 0 ? (dir == -1 ? (d <= check[0]) : (d >= check[0])) : (dir == -1 ? (d <= check[1]) : (d >= check[1])))) {
                        point[type] = check[type] - dir;
                    } else point[type] += dir * i;
                    if (result < point[0] * point[0] + point[1] * point[1]) {
                        result = point[0] * point[0] + point[1] * point[1];
                    }
                    break;
            }
        }
        return result;
    }
}
