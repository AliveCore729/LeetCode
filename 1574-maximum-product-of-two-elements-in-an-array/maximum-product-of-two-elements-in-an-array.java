class Solution {
    public int maxProduct(int[] nums) {
        int maxs=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(i==j){
                    continue;
                }else{
                    maxs=Math.max(maxs,(nums[i]-1)*(nums[j]-1));
                }
            }
        }
        return maxs;
    }
}