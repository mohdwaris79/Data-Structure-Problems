

class  Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class ReverseList {
    public Node reverse(Node head) {
        // code here
        
            Node curr=head;
            Node temp=null;
           
            if(head==null|| head.next==null)
            {
                return head;
            }
            
        while(curr!=null)
        {
           
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            
            curr=curr.prev;
        }
       if(temp!=null)
       {
           head=temp.prev;
       }
       return head;
    }
    public static void main(String args[])
    {
        ReverseList dll = new ReverseList();

        // Manually create DLL: 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // Link nodes
        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        // Reverse DLL
        head = dll.reverse(head);

        
        Node temp = head;
        System.out.println("Reversed DLL:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }


    }
}