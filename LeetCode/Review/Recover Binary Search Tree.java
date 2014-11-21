
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode r1=null, r2=null, pre=null;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        r1=r2=pre=null;
        inorder(root);
        if(r1!=null&&r2!=null){
            int val = r1.val;
            r1.val = r2.val;
            r2.val = val;
        }
    }
    
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(pre!=null && root.val<pre.val){
            if(r1==null){
                r1 = pre;
                r2 = root;
            }else{
                r2 = root;
            }
        }
        pre = root;
        inorder(root.right);
    }
}
