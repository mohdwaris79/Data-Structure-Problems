class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class LeafNode {
    void printLeaves(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        LeafNode ln = new LeafNode();
        System.out.print("Leaf Nodes: ");
        ln.printLeaves(root);
    }
}
