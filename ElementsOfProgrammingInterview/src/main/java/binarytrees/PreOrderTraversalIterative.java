package binarytrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreOrderTraversalIterative {

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList( 1,2,3,4,5,6,7 ), null,0 );

        System.out.println(BinaryTreeUtils.preOrderTraversalRecursion(root, new ArrayList<BTNode>()));
        System.out.println(preOrderIterative(root));
        System.out.println(preOrderIterative_TextBook(root));
    }

    public static List<BTNode> preOrderIterative( BTNode root ){
        List<BTNode> result = new ArrayList<BTNode>();
        result.add(root);
        int i =0;
        while(i < result.size()){
            BTNode current = result.get(i);
            if(current.left != null) {
                result.add(i+1, current.left );
            }
            if(current.right != null){
                result.add(i+2,current.right);
            }
            i++;
        }
        return result;
    }

    public static List<BTNode> preOrderIterative_TextBook( BTNode root ){
        List<BTNode> result = new ArrayList<BTNode>();
        ArrayDeque<BTNode> stack = new ArrayDeque<>();
        stack.add( root );
        while( !stack.isEmpty() ){
            BTNode current = stack.pop();
            result.add(current);
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }

        }
        return result;
    }
}
