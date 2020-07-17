
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_II {

   static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null,null),
                        new TreeNode( 6, null,null )
                ),
                new TreeNode(2,
                        new TreeNode(4, null,null),
                        new TreeNode( 6, null,null ))
        );

        //System.out.println(traverse(root));

    }

//    public static List<List<Integer>> traverse(TreeNode node){
//        List<List<Integer>>  rlist = new ArrayList<>();
//        LinkedList <TreeNode> ll = new LinkedList<>();
//        ll.add(node);
//        while (ll.size() >0){
//            int n = ll.size();
//            List<Integer> list = new ArrayList<>();
//            while(n >0){
//                TreeNode l = ll.poll();
//                if(l != null) {
//                    list.add(l.val);
//                    if (l.left != null)
//                        ll.add(l.left);
//                    if (l.right != null)
//                        ll.add(l.right);
//                }
//                n--;
//            }
//            System.out.println(list);
//            rlist.add(0, list);
//        }
//        return rlist;
//    }
}
