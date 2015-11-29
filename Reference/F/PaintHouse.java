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
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int k = costs[0].length;
         
        // dp[i][j] means the min cost painting for house i, with color j
        int[][] dp = new int[n][k];
         
        // Initialization
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
         
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m != j) {
                        dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
                    }
                }
            }
        }
         
        // Final state
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
         
        return minCost;
    }


A Time O(n*K) Solution:
Use two variables min1 and min2, where min1 is the minimum value, whereas min2 is next to the minimum value. 

Code (Java):
?
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int k = costs[0].length;
         
        // dp[j] means the min cost for color j
        int[] dp = new int[k];
        int min1 = 0;
        int min2 = 0;
 
        for (int i = 0; i < n; i++) {
            int oldMin1 = min1;
            int oldMin2 = min2;
             
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
             
            for (int j = 0; j < k; j++) {
                if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                    dp[j] = oldMin1 + costs[i][j];
                } else {
                    dp[j] = oldMin2 + costs[i][j];
                }
                 
                if (min1 <= dp[j]) {
                    min2 = Math.min(min2, dp[j]);
                } else {
                    min2 = min1;
                    min1 = dp[j];
                }
            }
             
        }
         
        return min1;
    }
}
