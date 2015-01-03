//Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//Try to solve it in linear time/space.
//Return 0 if the array contains less than 2 elements.
//You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

public class Solution {
    public int maximumGap(int[] num) {
        if(num==null || num.length<=1){
            return 0;
        }
        radixSort(num);
        int max = 0;
        for(int i=0; i<num.length-1; i++){
            if( (num[i+1]-num[i])>max )
                max = num[i+1]-num[i];
        }
        return max;
    }
    void countSort(int[] num, int nd){
        int[] val = new int[num.length];
        int[] count = new int[10];
        for(int i=0; i<num.length; i++){
            count[(num[i]/nd)%10]++;
        }
        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }
        for(int i=num.length-1; i>=0; i--){
            val[count[(num[i]/nd)%10]-1] = num[i];
            count[(num[i]/nd)%10]--;
        }
        for(int i=0; i<num.length; i++){
            num[i] = val[i];
        }
    }
    void radixSort(int[] num){
        int max = getMax(num);
        for(int nd=1; max/nd>0; nd*=10){
            countSort(num, nd);
        }
    }
    int getMax(int[] num){
        int m = Integer.MIN_VALUE;
        for (int i=0;i<num.length;i++){
            m = Math.max(m,num[i]);
        }
        return m;
    }
}
