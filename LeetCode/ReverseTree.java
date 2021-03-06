  Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes. 

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.


/* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 */
    TreeNode reverse(TreeNode root){
    	if(root==null)
    		return null;
    	TreeNode cur = root, parent = root.left, sibling = cur.right;
    	cur.left = cur.right = null;
    	while(parent!=null){
    		TreeNode newParent = parent.left;
    		TreeNode newSibling = parent.right;
    		parent.left = sibling;
    		parent.right = cur;
    		cur = parent;
    		parent = newParent;
    		sibling = newSibling;
    	}
    	return cur;
    }
	
