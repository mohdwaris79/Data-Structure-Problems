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
public class LeftView{
public static List<Integer> view(Node root)

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
                if(i==0)
                {
                    res.add(curr.val);
                }
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
        return res;

    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.left.left.left=new Node(5);
        List<Integer> views =view(root);
        System.out.println(views);
    }
    
}