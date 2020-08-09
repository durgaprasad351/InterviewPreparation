package binarytrees;

public class SuccessorInInorderTraversal {

    public static void main(String[] args) {
        BTNode tree1 = new BTNode(1);
        tree1.left  = new BTNode(2);
        tree1.right = new BTNode(3);

        System.out.println( successor(tree1) );

        tree1.right.left = new BTNode(4);


        System.out.println( successor(tree1) );

        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);

        node2.parent = node1;
        node3.parent = node2;
        node4.parent = node3;
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;

        System.out.println( successor(node4) );
    }

    private static BTNode successor(BTNode current) {
        if(current.right != null){
            current = current.right;
            while(current.left != null){
                current = current.left;
            }
            return current;
        }
            while(current.parent != null && current.parent.right == current) {
                current = current.parent;
            }

        return current.parent;
    }
}
