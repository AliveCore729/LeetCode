class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        return map.equals(map2);
    }
}