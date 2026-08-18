class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length,maxs=0;boolean a1=false,a2=false,l=true;
        for(int i=1;i<n-1;i++){
            maxs=Math.max(maxs,nums[i]);
            if(nums[0]!=nums[i]){
                l=false;
            }
            if(nums[0]==nums[i]){
                a1=true;
            }if(nums[i]==nums[n-1]){
                a2=true;
            }
        }
        int h=Math.max(nums[n-1],nums[0]);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int max=-1;
        for(int i:nums){
            if(map.get(i)==1){
                max=Math.max(max,i);
            }
        }
        if(k==1){
            return max;
        }
        else if(k==n){
            return Math.max(h,maxs);
        }
        else if(a1&&!a2){
            return nums[n-1]; 
        }else if(a2&&!a1){
            return nums[0];
        }else if(!a1&&!a2&&nums[0]==nums[n-1]){
            return -1;
        }else if(!a1&&!a2){
            return h;
        }
        else{
            return -1;
        }
    }
}