//Divide two integers without using multiplication, division and mod operator.
//
//Show Tags


public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;
        if(divisor==1)
            return dividend;
        boolean isPositive = (dividend>0&&divisor>0) || (dividend<0&&divisor<0);
        long ddl = dividend>0 ? (long)dividend : -(long)(dividend);
        long dsl = divisor>0 ? (long)divisor : -(long)(divisor);
        int result = dividePositive(ddl, dsl);
        return isPositive ? result : -result;
    }
    
    private int dividePositive(long divid, long divis){
        if(divid<divis)
            return 0;
        long ds = divis;
        int result = 0, i=0;
        while(divid>=ds){
            result += (1<<i);
            divid -= ds;
            ds <<= 1;
            i++;
        }
        return result+dividePositive(divid, divis);
    }
}
