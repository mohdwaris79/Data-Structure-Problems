class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class validateBST {

    public static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node node, long min, long max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        return isBSTUtil(node.left, min, node.val) &&
                isBSTUtil(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        if (isBST(root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is NOT a BST");
        }
    }
}
