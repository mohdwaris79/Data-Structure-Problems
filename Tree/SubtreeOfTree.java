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
public class SubtreeOfTree {
    public static boolean subtree(Node root, Node subroot)
    {
        if(root==null )
        {
            return false;
        }
        if(subroot==null)
        {
            return true;
        }
        if(isSame(root, subroot))
        {
            return true;
        }
       return subtree(root.left, subroot)||subtree(root.right, subroot);

    }
    private static boolean isSame(Node s, Node t)
    {
        if(s==null && t==null)
        {
            return true;
        }
        if(s==null || t==null)
        {
            return false;
        }
        return (s.val==t.val)&& isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.left.left=new Node(6);
        Node subroot=new Node(1);
        subroot.left=new Node(2);
        subroot.right=new Node(3);
        System.out.println(subtree(root, subroot));
    }
}
