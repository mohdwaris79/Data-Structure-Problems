class Node{
    int val;
    Node left;
    Node right;
    Node(int val)
    {
        this.val=val;
        left=right=null;
    }
}
public class preorderTraversal {
    public static void preorder(Node root)
    {
        if(root==null)
        {
            return;

        }
        preorder(root.left);
        System.out.println(root.val);
        preorder(root.right);

    }
    public static void main(String[] args) {
        
    
   
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        preorder(root);
        System.out.println();

    }
}
