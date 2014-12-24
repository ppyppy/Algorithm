int getHeight(TreeNode root){
	if(root==null)
		return 0;
	return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
}

boolean isBalanced(TreeNode T){
	if(T==null)
		return true;
	int diff = Math.abs( getHeight(T.left) - getHeight(T.right) );
	if(diff>1)
		return false;
	return isBalanced(T.left)&&isBalanced(T.right);
}

Although this works, it's not very efficient. On each node, we recurse through its entire subtree.
This means that getHeight is called repeatedly on the same nodes.The algorithm is therefore O(N^2).

boolean isBalanced(TreeNode T){
	if( checkHeight(T)==-1 )
		return false;
	else
		return true;
}

int checkHeight(TreeNode T){
	if(T==null)
		return 0;
	int lh = checkHeight(T.left);
	if(lh==-1)
		return -1;
	int rh = checkHeight(T.right);
	if(rh==-1)
		return -1;
	if(Math.abs(lh-rh)>1)
		return -1;
	return Math.max(lh, rh)+1;
}

Go through every node only once for the height, once child node is not balanced (-1), all the parent node will return -1.
So it is O(n), space is O(h).


