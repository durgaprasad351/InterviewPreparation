package linkedlist;

public class ReverseSubList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList( new int[] {1,2,3,4,5,6,7} );
        reverseSubList( list.head.next ,  3, 5 );
        System.out.println(list.toString());
    }

    public static void reverseSubList(ListNode head, int start, int end){

        ListNode cur = head;

        for(int i =1; i< start; i++){
            cur = cur.next;
        }
        ListNode p1 = cur;
        ListNode p = p1;
        for(int i= start; i<= end; i++){
            ListNode t = cur.next;
            cur.next = p;

        }
        ListNode p2 = cur;
        ListNode p2Next = p2.next;
        ListNode p1Next = p1.next;
        p1.next = p2;

     }
}
