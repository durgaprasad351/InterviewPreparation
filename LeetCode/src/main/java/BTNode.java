public class BTNode {

    public BTNode(int val){
        this.val = val;
    }

    public int val;

    public BTNode parent;

    public BTNode left;

    public BTNode right;

    //Used for Balanced BT Tree like AVL trees.
    public int heightOfNode;

    @Override public String toString() {
        return "BTNode{" +
                "val=" + val +
                ", heightOfNode=" + heightOfNode +
                '}';
    }
}
