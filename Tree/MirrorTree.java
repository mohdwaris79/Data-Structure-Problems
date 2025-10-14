class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class MirrorTree {
    // Mirror function
    Node mirror(Node root) {
        if (root == null) return null;

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
       
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        MirrorTree tree = new MirrorTree();

        System.out.print("Original Tree (Inorder): ");
        tree.inorder(root);
        System.out.println();

        // Mirror the tree
        tree.mirror(root);

        System.out.print("Mirrored Tree (Inorder): ");
        tree.inorder(root);
        System.out.println();
    }
}
