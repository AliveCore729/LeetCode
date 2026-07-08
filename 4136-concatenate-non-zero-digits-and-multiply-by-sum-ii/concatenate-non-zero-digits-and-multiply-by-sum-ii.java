class Solution {
    public int[] sumAndMultiply(String s, int[][] arr) {
        int[] sum=new int[s.length()];
        int[] count=new int[s.length()];
        ArrayList<Integer> num=new ArrayList<>();
        int summ=0,n=s.length();
        for(int i=0;i<n;i++){
            int dig= s.charAt(i)-'0';
            if(dig!=0){
                summ+=dig;
                num.add(dig);
            }
            sum[i]=summ;
            count[i]=num.size();
        }
        int m=num.size();
        long[] pow=new long[m+1];
        pow[0]=1;
        int mod=1000000007;
        for(int i=1;i<=m;i++){
            pow[i]=(pow[i-1]*10)%mod;
        }
        long[] prenum=new long[m+1];
        for(int i=1;i<=m;i++){
            prenum[i]=(prenum[i-1]*10+num.get(i-1))%mod;
        }
        int[] out=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int l= arr[i][0],r=arr[i][1];
            
            int digitSum = sum[r] - (l > 0 ? sum[l - 1] : 0);

            int start = (l > 0) ? count[l - 1] : 0;
            int end = count[r];

            int shift = end - start;
            long x = (prenum[end] - prenum[start] * pow[shift]) % mod;
            if (x < 0) x += mod;

            out[i] = (int) ((x * (digitSum % mod)) % mod);
        }
        return out;
    }
}