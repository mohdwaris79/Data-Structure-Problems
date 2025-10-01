import java.util.*;

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
public class RightView {
    public static List<Integer> RightView(Node root)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(i==size-1)
                {
                    res.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                     q.add(curr.right);
                
                }
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

         List<Integer> view = RightView(root);
        System.out.println("Right View: " + view);
    }

    
}
