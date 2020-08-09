package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeUtils {


    public static BTNode createBinaryTreeFromList(List<Integer> nodes,  BTNode parent, int startIndex){
        if(startIndex >= nodes.size()) return null;
        if(nodes.get(startIndex ) == null) return null;
        BTNode node = new BTNode(nodes.get(startIndex));
        node.parent = parent;
        node.left = createBinaryTreeFromList( nodes,  node,startIndex * 2 + 1);
        node.right = createBinaryTreeFromList( nodes,  node,startIndex * 2 + 2);
        return node;
    }

    public static List<BTNode> inOrderTraversalRecursion( BTNode root, List<BTNode> result ){
        if(root == null) return result;
        inOrderTraversalRecursion( root.left, result);
        result.add(root);
        inOrderTraversalRecursion( root.right, result);
        return result;
    }

    public static List<BTNode> preOrderTraversalRecursion( BTNode root, List<BTNode> result ){
        if(root == null)
            return result;
        result.add(root);

        preOrderTraversalRecursion( root.left, result);
        preOrderTraversalRecursion( root.right, result);
        return result;
    }

    public static List<BTNode> postOrderTraversalRecursion( BTNode root, List<BTNode> result ){
        if(root == null) return result;
        postOrderTraversalRecursion( root.left, result);
        postOrderTraversalRecursion( root.right, result);
        result.add(root);
        return result;
    }

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,6,7 ), null,0 );

        System.out.println("In Order --> " + inOrderTraversalRecursion( root, new ArrayList<BTNode>()));

        System.out.println("Pre Order --> " + preOrderTraversalRecursion( root, new ArrayList<BTNode>()));

        System.out.println("Post Order --> " + postOrderTraversalRecursion( root, new ArrayList<BTNode>()));

    }


}
