//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

//You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] num) {
        int count = 0, ret = num[0];
        for(int i=0; i<num.length; i++){
            if(count==0){
                count=1;
                ret = num[i];
            }else if(ret==num[i]){
                count++;
            }else{
                count--;
            }
        }
        return ret;
    }
}
