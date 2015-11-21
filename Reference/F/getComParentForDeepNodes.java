


public class Solution {
	    private MTreeNode getComParentForDeepNodes(MTreeNode root){
	    	if(root==null || root.children.size()==0)
	    		return root;
	    	return helper(root).node;
	    }
	    
	    private LTreeNode helper(MTreeNode root){
	    	if(root.children.size()==0){
	    		LTreeNode lnode = new LTreeNode(root);
	    		lnode.height=1;
	    		return lnode;
	    	}
	    	int maxHeight = 0;
	    	LTreeNode ret = null;
	    	for(MTreeNode node : root.children){
	    		LTreeNode lNode = helper(node);
	    		if(lNode.height+1>maxHeight){
	    			ret = lNode;
	    			maxHeight = lNode.height+1;
	    		}else if(lNode.height+1==maxHeight){
	    			ret = new LTreeNode(root);
	    		}
	    	}
	    	ret.height = maxHeight;
	    	return ret;
	    }
	    

	    public static void main(String agrs[]) {
	        boolean[] nums = new boolean[6];
	        Arrays.fill(nums, true);
	        nums[4] = false;
	        Solution s = new Solution();
	        MTreeNode n1 = new MTreeNode(1);
            MTreeNode n2 = new MTreeNode(2);
            MTreeNode n3 = new MTreeNode(3);
            MTreeNode n4 = new MTreeNode(4);
            MTreeNode n5 = new MTreeNode(5);
            MTreeNode n6 = new MTreeNode(6);
            MTreeNode n7 = new MTreeNode(7);
            MTreeNode n8 = new MTreeNode(8);
            MTreeNode n9 = new MTreeNode(9);
            MTreeNode n10 = new MTreeNode(10);
            MTreeNode n11 = new MTreeNode(11);

            n1.children.add(n2);
            n1.children.add(n3);
            n1.children.add(n4);
            n2.children.add(n5);
            n2.children.add(n6);
            n4.children.add(n7);
            n5.children.add(n8);
            n5.children.add(n9);
            n6.children.add(n10);
//            n7.children.add(n11);

	        System.out.println(s.getComParentForDeepNodes(n1).val);
	            
	    }
	}


class LTreeNode{
	MTreeNode node;
	int height;
	public LTreeNode(MTreeNode treeNode){
		node = treeNode;
	}
}

class MTreeNode{
	int val;
	List<MTreeNode> children;
	public MTreeNode(int value){
		this.val = value;
		children = new ArrayList<MTreeNode>();
	}
}
