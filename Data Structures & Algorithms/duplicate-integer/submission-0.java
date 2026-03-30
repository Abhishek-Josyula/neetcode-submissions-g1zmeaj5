class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> counter = new HashSet<Integer>();
        for (int i=0; i < nums.length; i++){
            if (counter.contains(nums[i])) return true;

            counter.add(nums[i]);
        }
        return false;
    }
}