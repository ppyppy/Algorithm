	   void PostOrderTraverse(TreeNode root){
		   if(root==null)
			   	return;
		   Stack<TreeNode> stack = new Stack<TreeNode>();
		   TreeNode pre=null, p=root;
		   while(p!=null || !stack.empty()){
			   while(p!=null){ //first goto left and put all left nodes to stack.
				   stack.push(p);
				   p = p.left;
			   }
			   p = stack.peek();
			   if(p.right==null || p.right==pre){ //not able to go right, print
				   System.out.println(p.val);
				   stack.pop();
				   pre = p;
				   p = null;
			   }else{
				   p = p.right; //go right
			   }
		   }
	   }
	   
	   Stack<TreeNode> stack = new Stack<TreeNode>();
	   TreeNode p = null;
	   TreeNode pre = null;
	   public void init(TreeNode root){
		   while(root!=null){
			   stack.push(root);
			   root=root.left;
		   }
		   p = stack.peek();
	   }
	   
	   public boolean hasNext(){
		   return p!=null;
	   }
	   
	   public TreeNode next(){
		   while(p.right!=null && p.right!=pre){
			   p = p.right;
			   while(p!=null){
				   stack.push(p);
				   p = p.left;
			   }
			   p = stack.peek();
		   }
		   stack.pop();
		   pre = p;
		   if(!stack.isEmpty())
			  p = stack.peek();
		   else
			  p = null;
		   
		   return pre;
	   }
	   
	   //if has the parent node
	   TreeNode p = null;
	   TreeNode pre = null;
	   public void init(TreeNode root){
		   if(root==null)
			   	return;
		   while(root.left!=null){
			   root=root.left;
		   }
		   p = root;
	   }
	   
	   public boolean hasNext(){
		   return p!=null;
	   }
	   
	   public TreeNode next(){
		   while(p.right!=null && p.right!=pre){
			   p = p.right;
			   while(p.left!=null){
				   p = p.left;
			   }
		   }
		   pre = p;
		   p = p.parent;
		   return pre;
	   }
	   
	   
	    

	    public static void main(String agrs[]) {
	    	Solution s = new Solution();
	        boolean[] nums = new boolean[6];
	        TreeNode t = new TreeNode(4);
	        t.left = new TreeNode(2);
	        t.left.left = new TreeNode(1);
	        t.left.right = new TreeNode(3);
	        t.right = new TreeNode(6);
	        t.right.left = new TreeNode(5);
	        t.right.right = new TreeNode(7);
	        s.init(t);
	        while(s.hasNext())
	        	System.out.println(s.next().val);
	            
	    }
