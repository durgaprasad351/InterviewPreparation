package linkedlist;

public class RightShift {

    public static void main(String[] args) {
        LinkedList list = new LinkedList( new int[] {1,2,3,4,5,6,7} );
        ListNode newHead = rightShift( list.head , 6 );
        list.head = newHead;
        System.out.println(list.toString());
    }

    private static ListNode rightShift(ListNode head, int n) {
       ListNode current = head;
       int size =1;
       while((current = current.next) != null) size++;
       System.out.println(size);
       if(n >= size) {
           n = n % size;
       }
       if (n == 0) {
           return head;
       }
       System.out.println("We have to move only items " + n);
       ListNode slow = head;
       ListNode fast = head;
       while(n-- > 0){
           fast = fast.next;
       }
       while(fast.next != null){
           slow = slow.next;
           fast = fast.next;
       }
       fast.next = head;
       head = slow.next;
       slow.next = null;
       return head;
    }

}
