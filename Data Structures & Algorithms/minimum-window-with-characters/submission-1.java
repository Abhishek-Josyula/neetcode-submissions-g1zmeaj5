class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        HashMap<Character, Integer> tmap = new HashMap();

        for (int i=0; i<t.length(); i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        String currMinSubstr = s+"a";

        int left = 0, right = 0;
        HashMap<Character, Integer> windowMap = new HashMap();
        while (right <= s.length()){
            if (!mapEquals(tmap, windowMap)){
                if (right<s.length()){
                    windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            } else{
                String subs = s.substring(left, right);
                if (subs.length()<currMinSubstr.length()){
                    currMinSubstr = subs;
                }
                windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                left++;
            }
        }
        
        if (currMinSubstr.length()>s.length()){
            return "";
        }

        return currMinSubstr;
    }

    public boolean mapEquals(HashMap<Character, Integer> t, HashMap<Character, Integer> window){
        for (Character c : t.keySet()){
            if (window.getOrDefault(c, -1) < t.get(c)) return false;
        }

        return true;
    }
}
