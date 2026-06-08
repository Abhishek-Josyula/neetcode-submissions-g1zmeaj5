class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        can = new HashMap<>();
        for (int i=0; i<candidates.length; i++){
            can.put(candidates[i], can.getOrDefault(candidates[i], 0) + 1);
        }
        HashSet<Integer> unique = new HashSet<>();
        solver(Arrays.stream(candidates).distinct().toArray(), target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }
    HashMap<Integer, Integer> can;
    public void solver(int[] nums, int target, List<List<Integer>> ans, List<Integer> curr, int curri, int tot){
        if (tot <= target){
            if(tot==target) {
                List<Integer> c = new ArrayList<>(curr);
                ans.add(c);
            }
        }else{
            return;
        }

        for (int i=curri; i<nums.length; i++){
            if (can.get(nums[i]) > 0){
                can.put(nums[i], can.get(nums[i]) - 1);
                curr.add(nums[i]);
                int pos = curr.size()-1;
                solver(nums, target, ans, curr, i, tot+nums[i]);
                curr.removeLast();
                can.put(nums[i], can.get(nums[i]) + 1);
            }
        }

    }
}
