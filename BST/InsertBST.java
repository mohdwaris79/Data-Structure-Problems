
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class InsertBST {

    
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val); 
        }
        if (val < root.val) {
            root.left = insert(root.left, val); 
        } else if (val > root.val) {
            root.right = insert(root.right, val); 
        }
        return root; 
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        Node root = null;
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 6);
        root = insert(root, 8);

       System.out.print("BST before inserting 12: ");
        inorder(root);
        System.out.println();

        // Insert 12
        root = insert(root, 12);

        System.out.print("BST after inserting 12: ");
        inorder(root);
    }
}
