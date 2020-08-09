package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Construct_BinaryTee_From_PreOrder_Markers {

    public static int currIndex = 0;

    public static void main(String[] args) {

           BTNode root =  construct( Arrays.asList( 1,2,3,null,null, 4, null, null, 5, null, null ));
        System.out.println( BinaryTreeUtils.preOrderTraversalRecursion( root, new ArrayList<BTNode>()) );
    }

    private static BTNode construct(List<Integer> preOrder) {
        Integer val = preOrder.get(currIndex);
        currIndex ++;

        if( val == null ) {
            return null;
        }
        BTNode root = new BTNode( val  );
        root.left = construct( preOrder );
        root.right = construct(preOrder);
        return root;
    }

}
