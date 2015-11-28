	   
	   int getRandom(int[] nums, int index){
		   int[] ranges = new int[nums.length];
		   for(int i=1; i<nums.length; i++){
			   ranges[i] = nums[i]-nums[i-1]-1;
			   ranges[i] += ranges[i-1];
		   }
		   int low=0; int high=ranges.length-1;
		   while(low<=high){
			   int mid = low+(high-low)/2;
			   if(ranges[mid]==index || (index<ranges[mid] && index>ranges[mid-1]) ){
				   return getvalue(nums, ranges, mid, index);
			   }else if(ranges[mid]<index){
				   low = mid+1;
			   }else{
				   high = mid-1;
			   }
		   }
		   return -1;
	   }
	   
	   int getvalue(int[] nums, int[] ranges, int mid, int index){
		   int n = index-ranges[mid-1];
		   return nums[mid-1]+n;
	   }
	   
	   		int[] nums = {2,7,20,1000};
	    	Solution s = new Solution();
	    	
	    	for(int i=0; i<100; i++){
	    		int index = (int)(Math.random()*995+1); //[2,7,20,1000] [0,4,16,995]
	    		int value = s.getRandom(nums, index);
	    		System.out.println(index + ":" + value);
	    	}
