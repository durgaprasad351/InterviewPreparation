import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeImpl implements BinarySearchTree {

    BTNode root;

    public BTNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.insert(9);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(11);
        binarySearchTree.insert(14);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(12);
        binarySearchTree.insert(13);
        binarySearchTree.insert(15);

        System.out.println(" Search for 56 " + binarySearchTree.search(14));

        binarySearchTree.levelOrderedTraversal(binarySearchTree.getRoot());

        binarySearchTree.delete(11);
        binarySearchTree.levelOrderedTraversal(binarySearchTree.getRoot());
        binarySearchTree.delete(9);
        binarySearchTree.levelOrderedTraversal(binarySearchTree.getRoot());
        binarySearchTree.delete(5);
        binarySearchTree.levelOrderedTraversal(binarySearchTree.getRoot());
    }

    @Override public void delete(int val) {
        if (root == null || root.val == val) {
            root = null;
            return;
        }

        BTNode t = search(val);
        if (t == null) {
            //Nothing to delete
            return;
        }

        if (t.right != null) {
            BTNode minRight = min(t.right);
            t.right.left = minRight.right;
            minRight.right = t.right;
            minRight.parent = t.parent;
            minRight.left = t.left;
            t.right.parent = minRight;
            if (t.parent.val > val) {
                t.parent.left = minRight;
            } else {
                t.parent.right = minRight;
            }
        }else if (t.left != null) {
            t.parent.left = t.left;
            t.left.parent = t.parent;
        }
    }

    @Override public BTNode search(int val) {
        BTNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void insert(int value) {
        BTNode node = new BTNode(value);
        // If root is empty make node as root
        if (root == null) {
            root = node;
            return;
        }
        // Traverse the tree to find the parent of this node.
        BTNode prev = root;
        while (prev != null) {
            if (prev.val > node.val) {
                if (prev.left == null) {
                    prev.left = node;
                    node.parent = prev;
                    prev = null;
                } else {
                    prev = prev.left;
                }
            } else {
                if (prev.right == null) {
                    prev.right = node;
                    node.parent = prev;
                    prev = null;
                } else {
                    prev = prev.right;
                }
            }
        }
    }

    public void delete(BTNode node) {

    }

    public BTNode min(BTNode node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public BTNode max(BTNode node) {
        return null;
    }

    public void height(BTNode node) {

    }

    @Override public BTNode ceiling(int val) {
        return null;
    }

    @Override public BTNode floor(int val) {
        return null;
    }

    @Override public int rank(int rank) {
        return 0;
    }

    @Override public BTNode select(int rank) {
        return null;
    }

    @Override public List<BTNode> range(int start, int end) {
        return null;
    }

    public void levelOrderedTraversal(BTNode btNode) {
        LinkedList<BTNode> nodesToVisit = new LinkedList<BTNode>();
        nodesToVisit.add(btNode);
        while (nodesToVisit.size() > 0) {
            BTNode first = nodesToVisit.pollFirst();
            System.out.print(first.val + " (" + first.heightOfNode + ")-> ");
            if (first.left != null) {
                first.left.heightOfNode = first.heightOfNode + 1;
                nodesToVisit.addLast(first.left);
            }
            if (first.right != null) {
                first.right.heightOfNode = first.heightOfNode + 1;
                nodesToVisit.addLast(first.right);
            }
        }
        System.out.println();
    }

}
