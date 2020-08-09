package binarytrees;

import java.util.Arrays;

public class SumTheRootToLeaf {
    /**
     * Design an algo to compute the sum of the binary numbers represented by the root-to-leaf paths.
     */
    public static void main(String[] args) {
        BTNode btNode = BinaryTreeUtils.createBinaryTreeFromList(Arrays.asList(1,0,1,0,1,0,0,0,1,null,1,null,0,null,0,null,null,null,null,0,null,1,0), null, 0 );
        System.out.println(InOrderTraversal.inOrderTraversalIterative( btNode));
        System.out.println(sumFromRootToLeaf(btNode, 0));
    }

    public static int sumFromRootToLeaf(BTNode root, int sumSoFar){
        if(root == null) return sumSoFar;
        sumSoFar = sumSoFar * 2 + root.val;
        return  sumFromRootToLeaf(root.left, sumSoFar) + sumFromRootToLeaf(root.right, sumSoFar);
    }
}

// 111 --> 1 --> 1*2 + 1 --> 3 --> 3*2 +1 --> 7
