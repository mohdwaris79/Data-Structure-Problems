
class Node{
int val;
Node left;
Node right;
Node(int val)
{
    this.val=val;
    
}
}
public class maxSum {
    static int maxSum=Integer.MIN_VALUE;
    public static int max(Node root)
    {
        if(root == null)
        {
            return 0;

        }
       int left = Math.max(0, max(root.left));
       int right = Math.max(0, max(root.right));
       maxSum = Math.max(maxSum, left+right+root.val);
       return root.val+Math.max(left, right);
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.left.left.left=new Node(5);
        max(root);
        System.out.println(maxSum);
    }
    
}
