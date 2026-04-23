class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int right = 0;

        Set<Character> substr = new HashSet<>();
        int longest = 0;
        while (right<s.length()){
            if (!substr.contains(s.charAt(right))){
                substr.add(s.charAt(right));
                right++;
                longest = Math.max(longest, substr.size());
            } else{
                substr.remove(s.charAt(left));
                left++;
            }
        }

        return longest;
    }
}
