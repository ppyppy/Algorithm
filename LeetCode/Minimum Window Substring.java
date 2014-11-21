Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String S, String T) {
        if(S==null || S.length()==0)
            return S;
        if( T==null )
            return null;
        if(T.length()==0 || S.length()<T.length() ){
            return "";
        }
        
        int[] toFind = new int[60];
        int[] found = new int[60];
        char[] tchs = T.toCharArray();
        char[] schs = S.toCharArray();
        for(int i=0; i<T.length(); i++)
            toFind[tchs[i]-'A']++;
            
        int start=-1, minLen=Integer.MAX_VALUE, minStart = 0, minEnd = -1;
        int len = 0;
        for(int i=0; i<S.length(); i++){
            if(toFind[schs[i]-'A']>0){ //hit the character in T
                if(start==-1)
                    start = i;
                found[schs[i]-'A']++;
                if( found[schs[i]-'A'] <= toFind[schs[i]-'A'] )
                    len++;
                if(len==T.length()){
                    while( toFind[schs[start]-'A']==0 || found[schs[start]-'A']>toFind[schs[start]-'A'] ){
                        if(found[schs[start]-'A']>toFind[schs[start]-'A'])
                            found[schs[start]-'A']--;
                        start++;
                    }
                    if( (i-start)<minLen ){
                        minLen = i-start;
                        minStart = start;
                        minEnd = i;
                    }
                    found[schs[start]-'A']--;
                    start++;
                    len--;
                }
            }
        }
        return S.substring(minStart, minEnd+1);
    }
}
