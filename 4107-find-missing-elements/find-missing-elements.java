class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> l=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            int curr=arr[i];
            int next=arr[i+1];
            if(next-curr!=1){
                for(int j=curr+1;j<next;j++){
                    l.add(j);
                }
            }

        }
        return l;
    }
}