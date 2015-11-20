给//一个数组是从1到N，就是sort好的1到N个整数，其中随机擦掉了k个数，如何uniformly sample剩下N-k个整数。不能无限次sample，空间复杂度O(k)	  
	  //
这样可能也行吧，但是要修改原来的array。我当时先给了naive的算法是把n-k个数copy出来再uniform sample，他说空间复杂度要o(k)，我就说那就只存每个区间的端点，比如存[(1,a1-1), (a1+1,a2-1), ..., (ak+1,N)]，然后再sample


//first location in which range, then uniform one in the range.
