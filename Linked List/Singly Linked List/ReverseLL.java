class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL{
public static Node reverse(Node head)
{
    if(head==null||head.next==null)
    {
        return head;
    }
    Node prev=null;
    Node curr=head;
    Node next=null;
    while(curr!=null)
    {
            next = curr.next;   
            curr.next = prev;   
            prev = curr;        
            curr = next;
    }
    return prev;
}
    
  public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        
        Node newHead = reverse(head);

        
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
    }
}
