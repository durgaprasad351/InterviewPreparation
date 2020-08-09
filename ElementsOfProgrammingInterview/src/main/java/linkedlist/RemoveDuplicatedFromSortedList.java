package linkedlist;

public class RemoveDuplicatedFromSortedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(new int[] {1,3,3,5,5,5,7,7,7,7,9,9,9,9,9});
        removeDuplicated( list1.head);
        System.out.println(list1);

        list1 = new LinkedList(new int[] {1,3,3,5,5,5,7,7,7,7,9,9,9,9,9});
        removeDuplicatedAfter( list1.head, 2);
        System.out.println(list1);
    }

    public static void removeDuplicated(ListNode start){
        ListNode last = start;
        ListNode current = start.next;
        while(current.next != null){
            if(last.val != current.val){
                last.next = current;
                last = current;
            }
            current = current.next;
        }
        last.next = null;
    }

    public static void removeDuplicatedAfter(ListNode start, int n){
        ListNode last = start;
        ListNode current = start.next;
        int c =n-1;
        while(current.next != null){
            if(last.val != current.val){
                last.next = current;
                last = current;
                c=n-1;
            }else if(c != 0){
                c--;
                last.next = current;
                last = current;
            }
            current = current.next;
        }
        last.next = null;
    }


}
