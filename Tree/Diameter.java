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
public class Diameter{
    static int diameter;
    public static int diameter(Node root)
    {
        
        height(root);
        return diameter;

    }
    private static int height(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight =height(node.right);
        diameter= Math.max(diameter, leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight)+1;

    }
    public static void main(String args[])
    {
        Node root=new Node(2);
        root.left=new Node(3);
        root.right=new Node(4);
        System.out.println(diameter(root));
    }
}