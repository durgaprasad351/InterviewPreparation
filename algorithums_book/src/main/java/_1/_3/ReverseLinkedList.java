package _1._3;

import java.util.Stack;

public class ReverseLinkedList {

    /**
     * Reverse a linked list using
     * 1. Using Stack
     *
     * 2. With out stack
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        LinkedList linkedList = new LinkedList(arr);
        linkedList.print();
        reverseUsingStack(linkedList);
        System.out.println("After reverse");
        linkedList.print();

        int[] arr2 = new int[]{1};
        LinkedList linkedList2 = new LinkedList(arr2);
        linkedList2.print();
        reverseUsingStack(linkedList2);
        System.out.println("After reverse");
        linkedList2.print();

        int[] arr3 = new int[]{1,2};
        LinkedList linkedList3 = new LinkedList(arr3);
        linkedList3.print();
        reverseUsingStack(linkedList3);
        System.out.println("After reverse");
        linkedList3.print();
    }

    private static void reverse(LinkedList linkedList) {
        if(linkedList.head == null || linkedList.head.next == null) return;
        Node f = linkedList.head;
        Node s = f.next;
        f.next = null;
        while(s != null){
            Node tmp = s.next;
            s.next = f;
            f =s;
            s = tmp;
        }
        linkedList.head = f;
    }

    private static void reverseUsingStack(LinkedList linkedList){
        Stack<Node> s = new Stack<>();
        Node n = linkedList.head;
        while(n != null){
            s.push(n);
            n = n.next;
        }
        linkedList.head = s.pop();
        Node prev  = linkedList.head;
        while(!s.isEmpty()){
            Node node = s.pop();
            prev.next = node;
            prev = node;
        }
        prev.next = null;
    }
}
