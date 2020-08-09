package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;

public class ExteriorOfBinaryTree {

    public static void main(String[] args) {
       BTNode root =  BinaryTreeUtils.createBinaryTreeFromList(Arrays.asList( 1,2,5,3,4,6,null , null,7, null, 8, null,9) ,  null, 0   );
        System.out.println(  BinaryTreeUtils.inOrderTraversalRecursion( root, new ArrayList<BTNode>()) );
        printExterior(root);
    }

    private static void printExterior(BTNode root) {
        System.out.println(root);
        printLeftMost(root.left);
        printRightMost(root.right);
    }

   private static void  printLeftMost(BTNode root){
        while(root  != null){
            System.out.println(root);
            if(root.right != null){
                printAllNullNodes(root.right);
            }
            root = root.left;
        }
   }

   private static void printRightMost(BTNode root){
        while(root  != null){
            System.out.println(root);
            if(root.left != null){
                printAllNullNodes(root.left);
            }
            root = root.right;
        }
   }

    private static void printAllNullNodes(BTNode node) {
        if(node.left == null && node.right == null){
            System.out.println(node);
            return;
        }
        if(node.left != null) {
            printAllNullNodes(node.left);
        }

        if(node.right != null) {
            printAllNullNodes(node.right);
        }
    }

}
