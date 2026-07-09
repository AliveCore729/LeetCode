class Solution {
    public long sumAndMultiply(int num) {
        String n=""+num;
        int sum=0;
        long ans=0L;
        for(int i=0;i<n.length();i++){
            if((n.charAt(i)-'0')!=0){
                ans=(ans*10)+(n.charAt(i)-'0');
                sum+=n.charAt(i)-'0';
            }
        }
        return ans*sum;
    }
}