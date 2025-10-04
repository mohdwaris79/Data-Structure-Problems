class Node {
    int val;
    Node left, right;
    Node(int val) { this.val = val; left = right = null; }
}

public class LCAinBST {

    public static Node findLCA(Node root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val)
            return findLCA(root.left, p, q);
        else if (p > root.val && q > root.val)
            return findLCA(root.right, p, q);
        else
            return root; // This is the split point
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        Node lca = findLCA(root, 5, 15);
        System.out.println("LCA of 5 and 15 is: " + lca.val);

        lca = findLCA(root, 5, 30);
        System.out.println("LCA of 5 and 30 is: " + lca.val);
    }
}
