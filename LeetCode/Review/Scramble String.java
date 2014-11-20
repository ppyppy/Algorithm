//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//Below is one possible representation of s1 = "great":
//
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//To scramble the string, we may choose any non-leaf node and swap its two children.
//
//For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//We say that "rgeat" is a scrambled string of "great".
//
//Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//We say that "rgtae" is a scrambled string of "great".
//
//Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null && s2==null)
            return true;
        if(s1==null || s2==null)
            return false;
        if(s1.length()!=s2.length())
            return false;
        return helper(s1, s2);
    }
    boolean helper(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        int[] A = new int[26];
        for(int i=0; i<s1.length(); i++){
            A[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<s2.length(); i++){
            A[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(A[i]!=0)
                return false;
        }
        if(s1.length()==1)
            return true;
        for(int i=1; i<s1.length(); i++){
            boolean ret = ( helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i), s2.substring(i)) );
            ret |= ( helper(s1.substring(0, i), s2.substring(s2.length()-i)) && 
                    helper(s1.substring(i), s2.substring(0, s2.length()-i)) );
            if(ret==true)
                return true;
        }
        return false;
    }
}