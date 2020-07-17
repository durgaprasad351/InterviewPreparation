import java.util.List;

public interface BinarySearchTree {

    /**
     * Get root of the tree.
     * @return
     */
    public BTNode getRoot();

    /**
     * Insert a node into the tree.
     * O(log h )
     * @param val
     */
    public void insert(int val);

    /**
     * Delete a node from tree.
     * O(log h)
     * @param val
     */
    public void delete(int val);

    public BTNode search(int val);

    /**
     * Find the min-element in the node sub tree.
     * O(log h)
     * @param node
     */
    public BTNode min(BTNode node);

    /**
     * Find the max-element in the node sub tree.
     * O(log h)
     * @param node
     */
    public BTNode max(BTNode node);

    /**
     * Find the height of the subtree.
     * O(log h)
     * @param node
     */
    public void height(BTNode node);

    public BTNode ceiling(int val);

    public BTNode floor(int val);

    public int rank(int rank);

    public BTNode select(int rank);

    public List<BTNode> range(int start, int end);

    /**
     * Travese nodes from root level by level.
     *
     * O(n)
     * @param btNode
     */
    public void levelOrderedTraversal(BTNode btNode);
}
