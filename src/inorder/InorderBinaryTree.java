package inorder;

import java.util.ArrayList;
import java.util.List;

public class InorderBinaryTree {
    public static void main(String[] args) {

        new InorderBinaryTree().inorderTraversal(null);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left != null) result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        if (root.right != null) result.addAll(inorderTraversal(root.right));
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
