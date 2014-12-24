    int pre = Integer.MIN_VALUE;
    boolean checkBST(TreeNode T){
    	if(T==null)
    		return true;
    	if(!checkBST(T.left))
    		return false;
    	if(T.val<pre)
    		return false;
    	if(!checkBST(T.right))
    		return false;
    	return true;
    }
