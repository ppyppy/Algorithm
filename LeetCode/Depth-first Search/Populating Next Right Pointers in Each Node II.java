//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
     public void connect(TreeLinkNode root) {
        TreeLinkNode cur=root, head=null, prev=null;
        while(cur!=null) {
            while(cur!=null) {
                if(cur.left!=null) {
                    if(prev!=null) prev.next = cur.left;
                    else head = cur.left;
                    prev=cur.left;
                }
                if(cur.right!=null) {
                    if(prev!=null) prev.next = cur.right;
                    else head = cur.right;
                    prev=cur.right;
                }
                cur=cur.next;
            }
            cur=head;
            head=null;
            prev=null;
        }
    }
    
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.addLast(root);
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        while(!queue.isEmpty()){
            list.clear();
            while(!queue.isEmpty()){
                list.add(queue.removeFirst());
            }
            TreeLinkNode pre = null;
            for(TreeLinkNode node : list){
                if(pre==null)
                    pre = node;
                else{
                    pre.next = node;
                    pre = node;
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
    }
    
    
}
