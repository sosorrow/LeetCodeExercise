/**
 * 四叉树
 */
public class QuadTree {
    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}};
        QuadTreeNode node = new QuadTree().construct(arr);

        while (node.topLeft != null) {
            System.out.println(node.topLeft);
            node = node.topLeft;
        }
    }

    public QuadTreeNode construct(int[][] grid) {
        for (int[] a : grid) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }

        boolean val, isLeaf;
        QuadTreeNode[][] nodes = new QuadTreeNode[grid.length / 2][grid[0].length / 2];
        for (int i=0; i<grid.length / 2; i++) {
            for (int j=0; j<grid[0].length / 2; j++) {
                val = grid[i*2][j*2] == 1 && grid[i*2+1][j*2] == 1 && grid[i*2][j*2+1] == 1 && grid[i*2+1][j*2+1] == 1;
                nodes[i][j] = new QuadTreeNode(
                        val,// true -> 1     false -> 0
                        grid[i*2][j*2] == grid[i*2][j*2+1] && grid[i*2][j*2] == grid[i*2+1][j*2] && grid[i*2][j*2] == grid[i*2+1][j*2+1],
                        null, null, null, null
                );
            }
        }

        return getQuadTreeNode(nodes);
    }

    public QuadTreeNode getQuadTreeNode(QuadTreeNode[][] grid) {
        if (grid.length * grid[0].length == 1) return grid[0][0];

        for (QuadTreeNode[] a : grid) {
            for (QuadTreeNode b : a) {
                System.out.print(((b.val ? "T": "F") + "-" + (b.isLeaf ? "T": "F")) + "\t\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        boolean val, isLeaf;
        QuadTreeNode[][] nodes = new QuadTreeNode[grid.length / 2][grid[0].length / 2];
        for (int i=0; i<grid.length / 2; i++) {
            for (int j=0; j<grid[0].length / 2; j++) {
                val = grid[i*2][j*2].val && grid[i*2+1][j*2].val && grid[i*2][j*2+1].val && grid[i*2+1][j*2+1].val;// true -> same ---> is 1  false -> diff ---> is 0
                isLeaf = val && grid[i*2][j*2].isLeaf && grid[i*2+1][j*2].isLeaf && grid[i*2][j*2+1].isLeaf && grid[i*2+1][j*2+1].isLeaf;
                nodes[i][j] = new QuadTreeNode(
                        val,
                        isLeaf,
                        isLeaf ? null : grid[i*2][j*2],
                        isLeaf ? null : grid[i*2][j*2+1],
                        isLeaf ? null : grid[i*2+1][j*2],
                        isLeaf ? null : grid[i*2+1][j*2+1]
                );
            }
        }

        return getQuadTreeNode(nodes);
    }
}

class QuadTreeNode {
    public boolean val;
    public boolean isLeaf;
    public QuadTreeNode topLeft;
    public QuadTreeNode topRight;
    public QuadTreeNode bottomLeft;
    public QuadTreeNode bottomRight;

    public QuadTreeNode() {}

    public QuadTreeNode(boolean _val,boolean _isLeaf,QuadTreeNode _topLeft,QuadTreeNode _topRight,QuadTreeNode _bottomLeft,QuadTreeNode _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
