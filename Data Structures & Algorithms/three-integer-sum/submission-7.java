class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

                int ai = nums[i];
                
                int left = i+1;
                int right = nums.length - 1;
                int target = -ai;
                boolean found = false;
                while (left<right){
                    if (nums[left]+nums[right]>target){
                        right--;
                    } else if (nums[left]+nums[right]<target){
                        left++;
                    } else{
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(ai);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        ans.add(triplet);

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }

                    
        }
        
        
        return ans;
    }
}
