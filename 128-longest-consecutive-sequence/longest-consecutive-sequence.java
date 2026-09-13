class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int i:nums) st.add(i);
        int max=0;
        for(int i:st){
            if(!st.contains(i-1)){
                int curr=i;
                int count=1;
                while(st.contains(curr+1)){
                    count++;
                    curr++;
                }
                max=Math.max(max,count);
            }
            
        }
        return max;
    }
}