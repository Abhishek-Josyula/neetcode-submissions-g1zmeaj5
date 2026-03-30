class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> NumsCount = new HashMap<Integer, Integer>();

        for(int i=0; i< nums.length; i++){
            NumsCount.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            if(NumsCount.getOrDefault(target-nums[i], -1) != -1){
                int j = NumsCount.getOrDefault(target-nums[i], -1);
                
                if (i==j) continue;
                
                return new int[] {i, j};
            }
        }

        return new int[] {0};
    }
}
