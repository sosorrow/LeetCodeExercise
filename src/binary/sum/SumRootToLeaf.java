package binary.sum;

import binary.TreeNode;

public class SumRootToLeaf {
    private int sum = 0;
    public static void main(String[] args) {
        System.out.print(new SumRootToLeaf().sumNumbers(new TreeNode()));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        caculateSum(root);

        return sum;
    }

    public void caculateSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            sum += root.val;
        }
        if (root.left != null) {
            root.left.val += root.val * 10;
            caculateSum(root.left);
        }
        if (root.right != null) {
            root.right.val += root.val * 10;
            caculateSum(root.right);
        }
    }
}
