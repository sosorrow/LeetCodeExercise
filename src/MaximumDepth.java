import java.util.ArrayList;
import java.util.List;

public class MaximumDepth {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        List<Node> list3 = new ArrayList<>();

        Node node3_1 = new Node(7, new ArrayList<>());
        list3.add(node3_1);

        Node node2_1 = new Node(5, list3);
        Node node2_2 = new Node(6, new ArrayList<>());
        list2.add(node2_1);
        list2.add(node2_2);

        Node node1_1 = new Node(2, list2);
        Node node1_2 = new Node(3, new ArrayList<>());
        Node node1_3 = new Node(4, new ArrayList<>());
        list.add(node1_1);
        list.add(node1_2);
        list.add(node1_3);
        Node root = new Node(1, list);
        System.out.print(new MaximumDepth().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.size() > 0) {
            int depth = 0;
            for (Node node: root.children) {
                depth = Math.max(depth, this.maxDepth(node));
            }
            return 1 + depth;
        }
        return 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
