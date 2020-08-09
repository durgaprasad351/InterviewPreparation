package linkedlist;

public class ReverseList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList( new int[] {1,2,3,4,5,6,7} );
        ListNode newHead = reverse2( list.head );
        list.head = newHead;
        System.out.println(list.toString());

        list = new LinkedList( new int[] {1,2} );
         newHead = reverse2( list.head );
        list.head = newHead;
        System.out.println(list.toString());

        LinkedList list2 = new LinkedList( new int[] {1,2,3,4,5,6,7,8,9,10} );
        reverseSublist( list2.head, 3, 8 );
        System.out.println(list2.toString());

        LinkedList list3 = new LinkedList( new int[] {1,2,3,4,5} );
        reverseSublist( list3.head, 2,5 );
        System.out.println(list3.toString());
    }

    private static ListNode reverse2(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while( current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous  =current;
            current = temp;
        }
        return previous;
    }

    private static void reverseSublist(ListNode next, int start, int end) {
        ListNode listHead = next;
        int i =1;
        while(i++ < start){
            listHead = listHead.next;
        }
        ListNode previous = null;
        ListNode subStart = listHead.next;
        ListNode current = listHead.next;
        while(i++ < end){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        listHead.next = previous;
        subStart.next = current;
    }

}
