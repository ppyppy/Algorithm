//Question:
//Given the root of a binary search tree and a value, find the "successor" of that value, 
//even if the value doesn't exist in the tree. 
//The "successor" is defined as the node appearing immediately after the given node when performing an in-order traversal.
   
    TreeNode getSuccessor(TreeNode root, int key){
    	if(root==null)
    		return null;
    	if(root.val==key){
    		return getLeftMost(root.right);
    	}else if(key>root.val){
    		return getSuccessor(root.right, key);
    	}else{
    		if(root.left!=null && key<getRightMost(root.left).val){
    			return getSuccessor(root.left, key);
    		}else{
    			return root;
    		}
    	}
    }
