package  linkedlist;

public class LinkedList {

    public ListNode head;

    public LinkedList(){

    }

    public LinkedList(int[] arr){
        head = new ListNode(arr[0]);
        ListNode current= head;
        for(int i =1; i< arr.length;i++){
            ListNode newListNode = new ListNode(arr[i]);
            current.next = newListNode;
            current = newListNode;
        }
    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(ListNode n = head; n != null; n =n.next){
            builder.append(n.val ).append("->");
        }
        builder.append("X");
        return builder.toString();
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
