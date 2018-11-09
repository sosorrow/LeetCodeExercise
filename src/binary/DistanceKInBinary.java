package binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceKInBinary {
    public static void main(String[] args) {
        TreeNode n = new TreeNode();
        TreeNode target = new TreeNode();

        for (int i : new DistanceKInBinary().distanceK(n, target, 3));
    }

    Map<Integer, Integer> m = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> r = new ArrayList<>();
        if (root == null || target == null) return r;
        if (K == 0) {
            r.add(target.val);
            return r;
        }

        checkBinary(root, target.val, K);

        r.addAll(m.keySet());
        return r;
    }

    public int checkBinary(TreeNode root, int target, int K) {
        int l = -1, r = -1;
        if (K == 0) {
            m.put(root.val, 1);
            return -1;
        }
        if (root.val == target || target == -1) {
            K--;
            if (root.left != null) checkBinary(root.left, -1, K);
            if (root.right != null) checkBinary(root.right, -1, K);
            return target == -1 ? -1 : K;
        } else {
            if (root.left != null) l = checkBinary(root.left, target, K);
            if (root.right != null) r = checkBinary(root.right, target, K);
            if (l == 0 || r == 0) {
                m.put(root.val, 1);
                return -1;
            }
            if (l > 0) {
                if (root.right != null) checkBinary(root.right, -1, l - 1);
                return l - 1;
            }
            if (r > 0) {
                if (root.left != null) checkBinary(root.left, -1, r - 1);
                return r - 1;
            }
            return -1;
        }
    }
}
