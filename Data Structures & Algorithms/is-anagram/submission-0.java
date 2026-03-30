class Solution {
    public boolean isAnagram(String s, String t) {
        char[] stringSMap = new char[26];
        char[] stringTMap = new char[26];

        if (s.length()!=t.length()) return false;

        for(int i=0; i < s.length(); i++){
            stringSMap[s.charAt(i)-'a'] += 1;
            stringTMap[t.charAt(i)-'a'] += 1;
        }

        for (int i=0; i<26; i++){
            if (stringSMap[i]!=stringTMap[i]){
                return false;
            }
        }

        return true;
    }
}
