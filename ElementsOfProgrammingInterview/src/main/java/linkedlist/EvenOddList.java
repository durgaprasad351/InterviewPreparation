package linkedlist;

public class EvenOddList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList( new int[] {1,2,3,4,5,6,7,8});
        list.head = evenOddList(list.head);
        System.out.println( list.toString() );
    }
    public static ListNode evenOddList(ListNode head){
        ListNode odd = null;
        ListNode even = null ;
        ListNode oddItr = null;
        ListNode evenItr = null;
        ListNode current = head;
        while(current != null){
            if(current.val % 2 == 0){
                if(even == null) {
                    even = current;
                    evenItr = current;
                }else{
                    evenItr.next = current;
                    evenItr = current;
                }
            }else{
                if(odd == null) {
                    odd = current;
                    oddItr = current;
                }else{
                    oddItr.next = current;
                    oddItr = current;
                }
            }
            current = current.next;
        }
        head = odd;
        oddItr.next = even;
        return head;
    }
}
