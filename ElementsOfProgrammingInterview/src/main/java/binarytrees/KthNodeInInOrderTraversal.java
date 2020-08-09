package binarytrees;

import java.util.Arrays;

public class KthNodeInInOrderTraversal {

    public static void main(String[] args) {

        BTNode btNode1 = new BTNode(1);
        BTNode btNode2 = new BTNode(2);
        BTNode btNode3 = new BTNode(3);
        BTNode btNode4 = new BTNode(4);
        BTNode btNode5 = new BTNode(5);
        BTNode btNode6 = new BTNode(6);
        BTNode btNode7 = new BTNode(7);

        btNode1.left = btNode2;
        btNode1.right = btNode3;

        btNode2.left = btNode4;
        btNode2.right = btNode5;

        btNode3.left = btNode6;
        btNode3.right = btNode7;

        btNode1.weight = 6;
        btNode2.weight = 2;
        btNode3.weight = 2;

        System.out.println( kthNodeInOrderTraversal( btNode1 , 6 ));
    }

    public static BTNode kthNodeInOrderTraversal(BTNode root, int  k ){
        BTNode itr = root;
        while( itr != null){
            int leftSize = itr.left == null ? 0 : itr.left.weight ;
            if(leftSize + 1 < k){
                k -= (leftSize +1);
                itr = itr.right;
            }else if (k == leftSize +1){
                return  itr;
            }else{
                itr = itr.right;
            }
        }
        return null;
    }

}
