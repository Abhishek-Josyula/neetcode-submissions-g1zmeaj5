class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
            List<Integer> start = new ArrayList<>();
            start.add(nums[0]);
            ans.add(start);

        for (int i=1; i<nums.length; i++){
            List<List<Integer>> temp = new ArrayList<>();
            for(int j=0; j<ans.size(); j++){
                if(ans.get(j).size() < nums.length){
                    List<Integer> t = ans.get(j);
                    for (int k=0; k<t.size(); k++){
                        ArrayList<Integer> t1 = new ArrayList<>(t);
                        t1.add(k, nums[i]);
                        temp.add(t1);
                    }
                    t.add(nums[i]);
                }
            }
            ans.addAll(temp);
        }

        return ans;
    }
}
