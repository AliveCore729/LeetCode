class Solution {
    private int gcd(int a,int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i:nums){
            l=i<l?i:l;
            r=i>r?i:r;
        }
        return gcd(l,r);
    }

}