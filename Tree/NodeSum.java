class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class NodeSum {
    public int nodeSum(Node root, int l, int r) {
        if (root == null) return 0;

        if (root.data < l) {
            return nodeSum(root.right, l, r);
        }

        if (root.data > r) {
            return nodeSum(root.left, l, r);
        }

        return root.data + nodeSum(root.left, l, r) + nodeSum(root.right, l, r);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create BST: [22, 12, 30, 8, 20]
        Node root = new Node(22);
        root.left = new Node(12);
        root.right = new Node(30);
        root.left.left = new Node(8);
        root.left.right = new Node(20);

        int l = 10, r = 22;

        Solution sol = new Solution();
        int result = sol.nodeSum(root, l, r);

        System.out.println("Sum of nodes in range [" + l + ", " + r + "] = " + result);
    }
}
