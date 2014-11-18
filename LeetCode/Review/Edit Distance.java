//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==null && word2==null)
            return 0;
        if(word1==null || word2==null){
            return word1==null ? word2.length() : word1.length();
        }
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++)
            dp[i][0] = i;
        for(int j=0; j<=len2; j++)
            dp[0][j] = j;
        for(int i=1; i<=len1; i++)
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int replace = dp[i-1][j-1] + 1; //str1a---str2b (a, b)
                    int add = dp[i][j-1] + 1; //str1a----str2 then str2+b = str2b
                    int delete = dp[i-1][j] + 1; //str1a----str1(delete a)----str2b
                    dp[i][j] = Math.min(replace, Math.min(add, delete));
                }
            }
        return dp[len1][len2];
    }
}