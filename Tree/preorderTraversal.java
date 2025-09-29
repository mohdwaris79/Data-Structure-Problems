import java.util.*;


class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class preorderTraversal {
    public static void Inorder(Node root, List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        ans.add(root.val);
        Inorder(root.left, ans);
        Inorder(root.right, ans);
    }
    
 public static void main(String[] args) {
        
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

       
        List<Integer> result = new ArrayList<>();
        Inorder(root, result);

        System.out.println("Inorder Traversal: " + result);
    }
}

