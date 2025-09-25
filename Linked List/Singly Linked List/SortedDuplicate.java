public class SortedDuplicate {
    public static ListNode Duplicate(ListNode head)
    {
        ListNode curr=head;
        
        while(curr.next!=null)
        {
            if(curr.val==curr.next.val)
            {
                curr.next=curr.next.next;
            }
            else{
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
        
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode h=Duplicate(l1);
        printList(h);
    }
    
}
