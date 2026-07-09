class Solution {
    public long sumAndMultiply(int num) {
        long n=0;int s=0;
        for(char c:String.valueOf(num).toCharArray()){
            if(c!='0'){
                n= (n*10)+c-'0';
                s+=c-'0';
            }
        }
        return n*s;
    }
}