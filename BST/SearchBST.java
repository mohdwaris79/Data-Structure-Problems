import  java.util.*;
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

public class SearchBST {
    public static boolean search(Node root, int key)
    {
        if(root==null)
        {
            return false;
        }
        if(root.val==key)
        {
            return true;
        }
        if(key<root.val)
        {
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
     
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        System.out.println(search(root, 2));
    }
    
}
