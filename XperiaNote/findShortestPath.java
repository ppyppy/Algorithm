//Question:
//Given the root of a binary search tree and two values, write a function that returns the path between the two values.
    TreeNode getCommonAncestor(TreeNode node, int value1, int value2){
    	if (node == null)
    		return null;
    	if (node.val > value2 && node.val > value1)
    		return getCommonAncestor(node.left, value1, value2);
    	else if (node.val < value2 && node.val < value1)
    		return getCommonAncestor(node.right, value1, value2);
    	else
    		return node;  	
    }
    
    List<TreeNode> getPath(TreeNode root, int value){
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	while(root!=null){
    		list.add(root);
    		if(root.val==value)
    			break;
    		else if(root.val<value)
    			root = root.right;
    		else
    			root = root.left;
    	}
    	return list;
    }
    
    List<TreeNode> getShortestPath(TreeNode root, int x, int y){
    	root = getCommonAncestor(root, x, y);
    	if(root==null)
    		return null;
    	if(x>y){
    		x = x^y;
    		y = x^y;
    		x = x^y;
    	}
    	List<TreeNode> left = getPath(root.left, x);
    	List<TreeNode> right = getPath(root.right, y);
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(left!=null)
    		list.addAll(left);
    	list.add(root);
    	if(right!=null)
    		list.addAll(right);
    	return list;
    }
