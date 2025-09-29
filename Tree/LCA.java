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
public class LCA {
    
    public static Node LCA(Node root,Node p, Node q)
    {
        if(root==null|| root==p||root==q)
        {
            return root;
        }
        
        Node Lleft = LCA(root.left, p, q);
        Node Lright = LCA(root.right, p, q);

        if (Lleft != null && Lright != null) {
            return root;
        }
        return (Lleft != null) ? Lleft : Lright;
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        Node p = root.left.left;   
        Node q = root.left.right;  

        Node lca = LCA(root, p, q);
       System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
