	   Given a list of houses and the cost of painting each house, the houses can be painted in three colors RED, GREEN and BLUE, 
	   two neighboring houses can’t be painted in the same color, calculate the total minimum cost for painting all houses.
	   
	   1) Dynamic programming problem. 
2)Maintain a array of min cost called min_cost, each column represent a color and each row represent a houses. 
3) min_cost[i][0] represents that, when the ith house is painted Red, the min cost of 0 to ith houses. Thus we have the following:

	   public int minPaintCost(int[][] cost) {
		   if(cost==null || cost.length==0)
			   return 0;
		   for(int i=1; i<cost.length; i++){
			   cost[i][0] = cost[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
			   cost[i][1] = cost[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
			   cost[i][2] = cost[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);
		   }
		   return Math.min(cost[cost.length-1][0], Math.min(cost[cost.length-1][1], cost[cost.length-1][2]));
	   }
