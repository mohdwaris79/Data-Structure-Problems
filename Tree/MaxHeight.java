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
public class MaxHeight {
    public static int Height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftHeight=Height(root.left);
        int rightHeight=Height(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(5);
        root.left.left.left.left.left = new Node(6);
        root.left.left.left.left.left.left = new Node(7);
        root.right=new Node(9);
        root.right.right=new Node(10);
        root.right.left=new Node(12);
       
        System.out.println(Height(root));
    }
}
