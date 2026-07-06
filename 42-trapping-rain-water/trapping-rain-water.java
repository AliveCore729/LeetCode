class Solution {
    public int trap(int[] arr) {
        int lmx=0,rmx=0,l=0,r=arr.length-1,count=0;
        while(l<r){
            lmx=Math.max(lmx,arr[l]);
            rmx=Math.max(rmx,arr[r]);
            if(lmx<rmx){
                count+=lmx-arr[l];
                l++;
            }else{
                count+=rmx-arr[r];
                r--;
            }
        }
        return count;
    }
}