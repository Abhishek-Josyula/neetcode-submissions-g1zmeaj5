class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()) return false;

        int[] s1Map = new int[26];
        for (int i=0; i<s1.length(); i++){
            s1Map[s1.charAt(i)-'a'] += 1;
        }

        int left = 0;
        int right = s1.length()-1;

        int[] substrMap = new int[26];
        for(int i=left; i<s1.length(); i++){
            substrMap[s2.charAt(i)-'a']+=1;
        }
        while (right<s2.length()){
                boolean eq = true;
                // check map
                for (int mcheck=0; mcheck<s1Map.length; mcheck++){
                    if (substrMap[mcheck]!=s1Map[mcheck]){
                        eq = false;
                        break;
                    }
                }

                if (eq) return true;

                substrMap[s2.charAt(left)-'a'] += -1;

                left++;
                right++;

                if (right<s2.length())
                substrMap[s2.charAt(right)-'a'] += 1;
                
        }

        return false;
    }
}
