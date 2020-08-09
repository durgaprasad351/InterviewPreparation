package linkedlist;

public class MergeTwoSortedLL {


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(new int[] {1,3,5,7,9});
        LinkedList list2 = new LinkedList(new int[]{2,4,6,8});

        LinkedList merged = merge(list1.head, list2.head);

        System.out.println(merged.toString());
    }

    private static LinkedList merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        //Traverse till one of the list is empty and append the non empty list to the end
        while(list1 != null && list2 != null ){
                current.next = new ListNode(-1);
                if(list1.val > list2.val){
                    current.next.val = list2.val;
                    list2 = list2.next;
                }else{
                    current.next.val = list1.val;
                    list1 = list1.next;
                }
                current = current.next;
        }
        current.next =  list1 == null ? list2 : list1;
        return new LinkedList(head.next);
    }

}
