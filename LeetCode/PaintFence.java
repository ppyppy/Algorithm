	There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
Note:
n and k are non-negative integers.
	
		        public int numWays(int n, int k) { 
		        	if(n==0 || k==0)
		        		return 0;
		        	int[] same = new int[n];
		        	int[] diff = new int[n];
		        	same[0] = 0;
		        	diff[0] = k;
		        	for(int i=1; i<n; i++){
		        		same[i] = diff[i-1];
		        		diff[i] = (same[i-1]+diff[i-1])*(k-1);
		        	}
		        	return same[n-1]+diff[n-1];
		        }
		        
		        public int numWays1(int n, int k) { 
		        	if(n==0 || k==0)
		        		return 0;
		        	int same=0;
		        	int diff=k;
		        	for(int i=1; i<n; i++){
		        		int preSame = same;
		        		same = diff;
		        		diff = (preSame+diff)*(k-1);
		        	}
		        	return same+diff;
		        }
