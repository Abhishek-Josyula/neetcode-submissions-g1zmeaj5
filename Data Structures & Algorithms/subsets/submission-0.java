class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (res.size()==0){
                List<Integer> choise = new ArrayList<>();
                choise.add(nums[i]);
                res.add(choise);
                res.add(new ArrayList<>());
            }
            else{
                List<List<Integer>> tmp = new ArrayList<>();
                for (int j = 0; j < res.size(); j++){
                    List<Integer> chooseiforj = new ArrayList<>(res.get(j));
                    chooseiforj.add(nums[i]);
                    tmp.add(chooseiforj);
                }

                res.addAll(tmp);
            }
            
           
        }
        return res;
    }
}
