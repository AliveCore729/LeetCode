class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> l=new ArrayList<>();
        Arrays.sort(arr);
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hm.add(arr[i]);
        }
        for(int i=arr[0];i<arr[arr.length-1];i++){
            if(!hm.contains(i)) l.add(i);
        }
        return l;
    }
}