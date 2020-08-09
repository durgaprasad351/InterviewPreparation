package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCAWithParentPointer {

    public static void main(String[] args) {

        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,6,7,8,9, null, null, null, null, null, 10 ), null, 0 );

        System.out.println( lca( root.left.left.right , root.left.right));
    }

    private static BTNode lca(BTNode node1, BTNode node2){
        List<BTNode> n1Ancestors = new ArrayList<>();
        List<BTNode> n2Ancestors = new ArrayList<>();
        node1 = node1.parent;
        while(node1 != null){
            n1Ancestors.add(node1);
            node1 = node1.parent;
        }
        node2 = node2.parent;
        while(node2 != null){
            n2Ancestors.add(node2);
            node2 = node2.parent;
        }
        List<BTNode> small = n1Ancestors.size() > n2Ancestors.size() ? n2Ancestors : n1Ancestors;
        List<BTNode> large = n1Ancestors.size() > n2Ancestors.size() ? n1Ancestors :  n2Ancestors;
        int i = 1 ;
        while( (i < small.size()) && (large.get( large.size() - i) == small.get( small.size() -i))){
            i++;
        }
        return large.get( large.size() -i );
    }
}
