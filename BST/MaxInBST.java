class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MaxInBST {

    // Find Minimum
    public static int findMin(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;  // keep moving left
        }
        return curr.val;
    }

    // Find Maximum
    public static int findMax(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;  // keep moving right
        }
        return curr.val;
    }

    public static void main(String[] args) {
        
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

      
        System.out.println("Maximum value: " + findMax(root));
    }
}
