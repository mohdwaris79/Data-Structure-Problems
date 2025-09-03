class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class RemoveLoop {
    public static Node remove(Node head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node slow=head;
        Node fast=head;
        boolean hasLoop = false;
        while(fast!=null&& fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
        }
       
    }
    if(!hasLoop)
    {
        return head;
    }
     slow = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

      
        fast.next = null;

        return head;
    }

  
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; 

        
        head = remove(head);

        // Print to verify loop removed
        printList(head); // Output: 1 2 3 4
    }
}

