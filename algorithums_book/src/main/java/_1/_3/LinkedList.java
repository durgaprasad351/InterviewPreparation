package _1._3;

public class LinkedList {
    public Node head;

    public LinkedList(int[] arr) {
        Node prev = new Node(arr[0]);
        head = prev;
        for(int i=1; i< arr.length;i++){
            Node n = new Node(arr[i]);
            prev.next = n;
            prev = n;
        }
    }

    public void print(){
        Node n = head;
        do{
            System.out.print(n.val);
            System.out.print("->");
            n = n.next;
        }while(n != null);
        System.out.println("\\N");
    }
}

class Node{
    public int val;
    public Node next;

    public Node(int i) {
        this.val =i;
    }
}
