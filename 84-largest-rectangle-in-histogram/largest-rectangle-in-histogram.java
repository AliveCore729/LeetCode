class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> s=new Stack<>();
        int[] n=new int[arr.length];
        int[] p=new int[arr.length];
        n[n.length-1]=n.length;
        for(int i=n.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
                s.pop();
            }
            n[i]=s.isEmpty()?n.length:s.peek();
            s.push(i);
        }
        while(!s.isEmpty()) s.pop();
        p[0]=-1;
        for(int i=0;i<p.length;i++){
            while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
                s.pop();
            }
            p[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        int maxs=0;
        for(int i=0;i<arr.length;i++){
            maxs= Math.max(maxs,arr[i]*(n[i]-p[i]-1));
        }
        return maxs;
    }
}