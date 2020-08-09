package linkedlist;

public class ArbitaryIntegerAddition {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList( new int[] {3,2,1} );
        LinkedList list2 = new LinkedList( new int[] {9,9,9} );
        LinkedList newList =  add(list1.head, list2.head);
        System.out.println(newList.toString());
    }

    private static LinkedList add(ListNode list1, ListNode list2) {
        int carry = 0;
        ListNode add = new ListNode(-1);
        LinkedList newList = new LinkedList();
        newList.head = add;
        while(list1 != null && list2 != null ){
            int temp = ( list1 != null ? list1.val : 0 ) + (list2 != null ? list2.val : 0) + carry;
            carry = temp / 10;
            temp = temp %10;
            add.next = new ListNode(temp);
            add = add.next;
            list1 = list1!= null ? list1.next : null;
            list2 = list2!= null ? list2.next : null;
        }
        if(carry != 0){
            add.next = new ListNode(carry);
        }
        newList.head = newList.head.next;
        return  newList;
    }
}
