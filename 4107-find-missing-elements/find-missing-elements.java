class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> l=new ArrayList<>();
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],1);
        }
        for(int i=arr[0];i<arr[arr.length-1];i++){
            if(!hm.containsKey(i)) l.add(i);
        }
        return l;
    }
}