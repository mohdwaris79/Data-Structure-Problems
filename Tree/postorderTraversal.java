import java.util.*;
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
public class postorderTraversal {
    public static void postorder(Node root, List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
    
public static void main(String[] args) {
        
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

       
        List<Integer> result = new ArrayList<>();
        postorder(root, result);

        System.out.println("Inorder Traversal: " + result);
    }
}
