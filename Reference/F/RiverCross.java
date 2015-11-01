//跳河问题。给一个0/1数组R代表一条河，0代表水，1代表石头。起始位置R[0]等于1，
//初速度为1. 每一步可以选择以当前速度移动，或者当前速度加1再移动。只能停留在石
//头上。问最少几步可以跳完整条河流。
//
//给定数组为R=[1,1,1,0,1,1,0,0]，最少3步能过河：
//第一步先提速到2，再跳到R[2]；
//第二步先提速到3，再跳到R[5]；
//第三步保持速度3，跳出数组范围，成功过河。
 //O(2^n)
	int getLeastSteps(int[] nums){
		if(nums==null || nums.length==0)
			return 0;
		return helper(nums, 0, 1);
	}
	
	int helper(int[] nums, int pos, int speed){
		if(pos>=nums.length)
			return 0;
		else if(nums[pos]==0)
			return nums.length;
		else{
			return 1+Math.min(helper(nums, pos+speed, speed), helper(nums, pos+speed+1, speed+1));
		}
	}
	//O(n)
	int getLeastSteps(int[] nums){
		if(nums==null || nums.length==0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int pos = 0, speed = 1;
		int steps = 0;
		Set<Integer> set = new HashSet<Integer>();
		while(pos<nums.length){
			if(nums[pos]==0 && stack.isEmpty()){
				return -1;
			}else if(nums[pos]==0 && !stack.isEmpty()){
				pos = stack.pop();
				speed --;
				steps --;
			}else {
				if(!set.contains(pos)){
					stack.add(pos);
					speed++;
					set.add(pos);
				}
				steps++;
				pos = pos+speed;
			}
		}
		return steps;
	}
