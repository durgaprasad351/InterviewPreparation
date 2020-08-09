package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class Construct_BinaryTree_From_InOrder_PreOrder {
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
        List<BTNode> inOrder = new ArrayList<>();
        List<BTNode> preOrder = new ArrayList<>();
        BinaryTreeUtils.inOrderTraversalRecursion(node1, inOrder);
        BinaryTreeUtils.preOrderTraversalRecursion(node1,preOrder);
        constructBtTree(inOrder, preOrder);
    }

    private static void constructBtTree(List<BTNode> inOrder, List<BTNode> preOrder) {
        BTNode root = constructBT_Helper( inOrder, preOrder  );
        System.out.println("Constructed " + BinaryTreeUtils.inOrderTraversalRecursion( root, new ArrayList<BTNode>() )  );
    }

    private static BTNode constructBT_Helper(List<BTNode> inOrder, List<BTNode> preOrder) {
        if(inOrder.size() == 0)
                return null;
        BTNode  parent = new BTNode(preOrder.get(0).val);
        if(inOrder.size() ==1 ){
            return  parent;
        }
        int index = inOrder.indexOf(  parent );
        List<BTNode>  inLeftSubTree =  inOrder.subList(0, index   );
        List<BTNode>  inRightSubTree =  inOrder.subList( index +1, inOrder.size()  );
        List<BTNode>  preLeftSubTree =  preOrder.subList(1,  inLeftSubTree.size() +1 );
        List<BTNode>  preRightSubTree =  preOrder.subList(  inLeftSubTree.size()+1,  preOrder.size() );
        parent.left  =  constructBT_Helper( inLeftSubTree, preLeftSubTree );
        parent.right  =  constructBT_Helper( inRightSubTree, preRightSubTree);
        return  parent;
    }

}
