class  Node{
    int val;
    Node left;
    Node right;
    Node(int val)
    {
        this.val=val;
        left=right=null;
    }
}
public class IdenticalTrees {
    public static boolean isIdentical(Node root1, Node root2){
        if(root1==null && root2==null)
        {
            return true;
        }
        if(root1==null || root2==null)
        {
            return false;
        }
        return (root1.val==root2.val) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    public static void main(String args[])
    {
        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(3);
        root1.left.left=new Node(4);
        root1.left.right=new Node(5);

        Node root2=new Node(1);
        root2.left=new Node(2);
        root2.right=new Node(3);
        root2.left.left=new Node(4);
        root2.left.right=new Node(5);

        System.out.println(isIdentical(root1, root2));

    }
    
}
