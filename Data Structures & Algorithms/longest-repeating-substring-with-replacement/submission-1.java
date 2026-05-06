class Solution {
    public int characterReplacement(String s, int k) {
        if (s==null || s.length()==0) return -1;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char currentC = s.charAt(0);
        int maxc = 0;
        int maxwin = 0;
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);                
            maxc = Math.max(maxc, map.get(s.charAt(r)));
            
            while(r-l+1-maxc>k && r < s.length()){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxwin = Math.max(maxwin, r-l+1);
            r++;
        }
        return maxwin;
    }
}
