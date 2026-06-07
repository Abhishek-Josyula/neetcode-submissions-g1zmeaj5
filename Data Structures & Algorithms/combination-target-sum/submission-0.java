class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solver(nums, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void solver(int[] nums, int target, List<List<Integer>> ans, List<Integer> curr, int curri, int tot){
        if (tot <= target){
            if(tot==target) ans.add(new ArrayList(curr));
        }else{
            return;
        }

        for (int i=curri; i<nums.length; i++){
            curr.add(nums[i]);
            int pos = curr.size()-1;
            solver(nums, target, ans, curr, i, tot+nums[i]);
            curr.removeLast();
        }

    }
}
