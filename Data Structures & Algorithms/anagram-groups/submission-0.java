class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<String, List<String>>();

        for (int i=0; i < strs.length; i++){
            String key = "";
            int[] map = new int[26];

            for (int j=0;  j < strs[i].length(); j++)        
            {
                map[strs[i].charAt(j) - 'a']+=1;
            }

            StringBuilder sb = new StringBuilder();
            for (int count : map) {
                sb.append('#'); // Use a delimiter to separate counts
                sb.append(count);
            }
            key = sb.toString();

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<List<String>>(groups.values()); 
    }
}
