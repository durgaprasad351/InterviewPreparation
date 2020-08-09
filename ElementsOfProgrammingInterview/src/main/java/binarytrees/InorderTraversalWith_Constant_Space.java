package binarytrees;

import java.util.ArrayList;

public class InorderTraversalWith_Constant_Space {

    public static void main(String[] args) {
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);
        BTNode node6 = new BTNode(6);
        BTNode node7 = new BTNode(7);
        BTNode node8 = new BTNode(8);

        node1.left = node2;
        node2.parent = node1;
        node1.right = node7;
        node7.parent = node1;

        node2.left = node3;
        node3.parent = node2;
        node2.right = node4;
        node4.parent = node2;

        node4.left = node5;
        node5.parent = node4;
        node4.right = node6;
        node6.parent = node4;

        node7.right = node8;
        node8.parent = node7;

        System.out.println(BinaryTreeUtils.inOrderTraversalRecursion( node1,  new ArrayList<BTNode>()));
        inordertraversal(node1);
    }

    public static void inordertraversal(BTNode root) {
        BTNode previous = null;
        BTNode current = root;
        while(current != null){
            BTNode next = null;
            //While going down  parent will be the previous node
            if(current.parent == previous){
                if(current.left != null){
                    next = current.left;
                }else{
                    //Either go to right node or go to parent
                    System.out.print( current );
                    next = current.right == null ? current.parent : current.right;
                }
            }else if( previous == current.left ){
                //Just return to parent after visiting left subtree
                System.out.print(current);
                //Either go to right node or go to parent
                next = current.right == null ? current.parent : current.right;
            }else if (previous == current.right){
                //Just returned after visting right subtree
                //move to parent
                next = current.parent;
            }
            previous = current;
            current = next;
        }
    }

}
