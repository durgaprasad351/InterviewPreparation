package binarytrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOrderTraversal {

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(Arrays.asList( 1,2,3,4,5,6,7,8,9, null, null, null, null, null, 10 ), null,0 );
        System.out.println( BinaryTreeUtils.inOrderTraversalRecursion( root , new ArrayList<BTNode>(){}));
        System.out.println(inOrderTraversalIterative(root));
        System.out.println(inOrderTraversal_TextBook_Solution(root));
    }

    public static List<BTNode> inOrderTraversalIterative(BTNode root){
        List<BTNode> result = new ArrayList<>();
        ArrayDeque<BTNode> stack = new ArrayDeque<>();
        BTNode current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
        while(!stack.isEmpty()){
            current = stack.pop();
            result.add(current);
            if(current.right != null){
                stack.push(current.right);
                if(current.right.left != null){
                    BTNode left = current.right.left;
                    while(left != null){
                        stack.push(left);
                        left = left.left;
                    }
                }
            }
        }
        return result;
    }

    public static List<BTNode> inOrderTraversal_TextBook_Solution(BTNode root){
        List<BTNode> result = new ArrayList<>();
        ArrayDeque<BTNode> stack = new ArrayDeque<>();
        BTNode current = root;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                result.add(current);
                current = current.right;
            }
        }
        return  result;
    }
}
