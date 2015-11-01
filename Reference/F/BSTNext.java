//Iterator for in-order traversal of binary tree.  开始以为是iterative traverse in-order binary tree
//
//
//class Iterator
//{
//    Iterator(Node *root){ }
//    int value(){ }. Waral 鍗氬鏈夋洿澶氭枃绔�,
//    void next(){ }. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
//
//}

class IteratorOfInOrder {        
    private TreeNode curNode;
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public IteratorOfInOrder(TreeNode root){
    	addNode(root);
    	next();
    }
    public int value(){                        
            return curNode.val;           
    }
    private void addNode(TreeNode node){
    	stack.add(node);
    	while(node.left!=null){
    		stack.add(node.left);
    		node = node.left;
    	}
    }
    public void next(){
    	  if(stack.isEmpty())
    		  return;
          curNode = stack.pop();
          if(curNode.right!=null)
        	   addNode(curNode.right);
    }
}
