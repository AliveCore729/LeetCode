class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        
        int[] arr={-1};
        for(int i=0;i<nums.length;i++){
            int a=target-nums[i];
            if(map.containsKey(a)){
                arr=new int[]{i,map.get(a)};
                return arr;
            }  
            map.put(nums[i],i);

        }
        return arr;
    }
}