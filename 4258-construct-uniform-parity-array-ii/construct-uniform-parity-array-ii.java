class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean hasOdd = false;
        int minOdd = Integer.MAX_VALUE;

        for (int x : nums1) {
            if ((x & 1) != 0) {
                hasOdd = true;
                minOdd = Math.min(minOdd, x);
            }
        }
        if (!hasOdd) return true;
        for (int x : nums1) {
            if ((x & 1) == 0 && x < minOdd) {
                return false;
            }
        }
        return true;
    }
}