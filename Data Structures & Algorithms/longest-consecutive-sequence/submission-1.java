class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, ArrayList<Integer>> seq = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            if (seq.containsKey(nums[i])){
                continue;
            }

            // merge
            if (seq.containsKey(nums[i]-1) && seq.containsKey(nums[i] + 1)){
                ArrayList<Integer> newGroup = seq.get(nums[i]-1);
                newGroup.add(nums[i]);
                newGroup.addAll(seq.get(nums[i] + 1));
                seq.put(nums[i], newGroup);
                seq.put(nums[i]-1, newGroup);
                seq.put(nums[i]+1, newGroup);
                maxLength = (int)Math.max(maxLength, newGroup.size());
                continue;
            }

            if(seq.containsKey(nums[i]-1)){
                ArrayList<Integer> newGroup = seq.get(nums[i]-1);
                newGroup.add(nums[i]);
                seq.put(nums[i], newGroup);
                seq.put(nums[i]-1, newGroup);
                maxLength = (int)Math.max(maxLength, newGroup.size());
            }else if (seq.containsKey(nums[i]+1)){
                ArrayList<Integer> newGroup = new ArrayList<>();
                newGroup.add(nums[i]);
                newGroup.addAll(seq.get(nums[i]+1));
                seq.put(nums[i], newGroup);
                seq.put(nums[i]+1, newGroup);
                maxLength = (int)Math.max(maxLength, newGroup.size());
            } else{
                ArrayList<Integer> newGroup = new ArrayList<>();
                newGroup.add(nums[i]);
                seq.put(nums[i], newGroup);
                maxLength = (int)Math.max(maxLength, newGroup.size());
            }
        }
        return maxLength;
    }
}
