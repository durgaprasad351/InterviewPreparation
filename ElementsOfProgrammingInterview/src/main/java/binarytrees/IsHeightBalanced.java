package binarytrees;

import java.util.Arrays;

public class IsHeightBalanced {
    /**
     * For a given binary tree difference of height between left and right subtees are at most one.
     */

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,6,7,8,9 ), null,0 );
        System.out.println(" Expeted : true , Result : " +isHeightBalanced( root)); // True Expected

        root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,null,null,8,9, 10 ), null,0 );

        System.out.println(" Expeted : false , Result : " + (getMaxHeight( root,0)  == -1 )); // false Expected
    }

    public static boolean isHeightBalanced(BTNode root){
        int leftHeight = getMaxHeight(root.left, 0);
        int rightHeight = getMaxHeight(root.right, 0);
        System.out.println("Left : " + leftHeight);
        System.out.println("Right : " + rightHeight);
        if(leftHeight == -1 || rightHeight == -1){
            return false;
        }
        return Math.abs( leftHeight - rightHeight ) <=  1;
    }

    public static int  getMaxHeight(BTNode root, int height){
        if(height == -1) return -1;
        if(root == null) return height;
        int leftHeight = getMaxHeight( root.left, height +1 );
        int rightHeight = getMaxHeight( root.right, height +1 );
        //We have to check at each subtree level if they are balanced
        if(Math.abs( leftHeight - rightHeight ) > 1){
            return -1;
        }
        return Math.max( leftHeight , rightHeight );
    }
}
