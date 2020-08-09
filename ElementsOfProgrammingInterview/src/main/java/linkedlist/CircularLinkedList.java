package linkedlist;

public class CircularLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n4;

        ListNode c = findStartOfCycle(n1);
        System.out.println(c.val);
    }

    public static ListNode findStartOfCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Cycle found");
                int c =0;
                do{
                    fast = fast.next;
                    c++;
                }while(slow != fast);
                System.out.println("Cycle Size :" + c);
                slow = head;
                fast = head;
                while(c > 0){
                    fast = fast.next;
                    c--;
                }
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }


}
