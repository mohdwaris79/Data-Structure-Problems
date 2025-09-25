import java.util.HashSet;

public class UnsortedDuplicate {
    public static ListNode Duplicate(ListNode head)
    {
        ListNode curr=head;
        HashSet<Integer> seen=new HashSet<>();
        seen.add(curr.val);
        while(curr.next!=null)
        {
            if(seen.contains(curr.next.val))
            {
                curr.next=curr.next.next;
            }
            else{
                seen.add(curr.next.val);
                curr=curr.next;
            }
        }
        return head;
    }
   public static void printList(ListNode head) {
    while(head != null) {
        System.out.print(head.val + " -> ");
        head = head.next;
    }
    System.out.println("null");
}
    public static void main(String args[])
    {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(2);
        l1.next.next.next=new ListNode(1);
        ListNode h=Duplicate(l1);
        printList(h);
    }
    
}
