class Solution {
    public int divide(int dividend, int divisor) {
        int ans=0;
        if(divisor!=0){
            ans= dividend/divisor;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        return ans;
    }
}