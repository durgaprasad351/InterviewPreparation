package binarytrees;

public class BTNode implements Comparable{
    public int val;
    public BTNode left;
    public BTNode right;
    public BTNode parent;
    public int weight =1;

    public BTNode(int val){
        this.val = val;
    }

    public BTNode(int val, BTNode left, BTNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BTNode(int val, BTNode left, BTNode right, BTNode parent){
        this(val,left, right);
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public int compareTo(Object o) {
        return Integer.valueOf(val).compareTo(((BTNode)o).val);
    }

    @Override
    public boolean equals(Object obj) {
        return this.val == ((BTNode)obj).val;
    }
}
