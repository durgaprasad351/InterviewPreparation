package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootToLeafWithSpecifiedSum {

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createBinaryTreeFromList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7), null, 0);
        System.out.println(BinaryTreeUtils.inOrderTraversalRecursion(root, new ArrayList<BTNode>() {
        }));
        System.out.println(rootToLeafSum(root, 10));
    }

    public static List<BTNode> rootToLeafSum(BTNode root, int sum) {

        if (sum - root.val == 0) {
            List<BTNode> returnList = new ArrayList<>();
            returnList.add(root);
            return returnList;
        }
        if (root.left != null) {
            List<BTNode> leftResult = rootToLeafSum(root.left, sum - root.val);
            if (leftResult != null) {
                leftResult.add(root);
                return leftResult;
            }
        }
        if (root.right != null) {
            List<BTNode> rightResult = rootToLeafSum(root.right, sum - root.val);
            if (rightResult != null) {
                rightResult.add(root);
                return rightResult;
            }
        }
        return null;
    }

}
