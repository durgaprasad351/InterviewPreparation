package binarytrees;

import java.util.Arrays;

public class LowestCommonAncestor {

    static class LCAResult{
        boolean isFound;
        BTNode lca;
        public LCAResult(boolean isFound, BTNode lca){
            this.isFound = isFound;
            this.lca = lca;
        }

        @Override public String toString() {
            return "LCAResult{" +
                    "isFound=" + isFound +
                    ", lca=" + lca +
                    '}';
        }
    }

    public static void main(String[] args) {

        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,6,7,8,9, null, null, null, null, null, 10 ), null, 0 );

        System.out.println( InOrderTraversal.inOrderTraversal_TextBook_Solution(root)  );
        LCAResult result = isFound( root, 2,10);
        System.out.println( result.isFound + "  " + result.lca );

        result = isFound( root, 9,5);
        System.out.println( result.isFound + "  " + result.lca );

    }

    public static LCAResult isFound(BTNode root, int l1, int l2 ){
        if(root == null){
            return new LCAResult(false, null);
        }
        if(l1 == root.val || l2 == root.val){
            return new LCAResult(true, null);
        }
        LCAResult left = isFound(root.left , l1, l2);
        LCAResult right = isFound(root.right , l1, l2);
        if(left.isFound && left.lca != null)
            return left;
        if(right.isFound && right.lca != null)
            return right;
        if(left.isFound && right.isFound ){
            return new LCAResult(true, root);
        }
        return new LCAResult( left.isFound || right.isFound , null );
    }

}
