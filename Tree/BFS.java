import java.util.*;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val)
    {
        this.val=val;
    }
}
public class BFS {
    public static void  level(Node root)
    {
        if(root==null)
        {
            return;
        }
        Queue<Node> q=new LinkedList<>();
         q.add(root);
        while(!q.isEmpty())
        {
           
            Node curr=q.poll();
            System.out.println(curr.val);
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);

            }
        }
    }
    
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
       level(root);
    }
    
}
