import java.util.*;


class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class InorderTraversal {

    // Recursive inorder traversal
    public static void inorder(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);    // Visit left subtree
        ans.add(root.val);         // Visit root
        inorder(root.right, ans);  // Visit right subtree
    }

    public static void main(String[] args) {
        
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

       
        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        System.out.println("Inorder Traversal: " + result);
    }
}
