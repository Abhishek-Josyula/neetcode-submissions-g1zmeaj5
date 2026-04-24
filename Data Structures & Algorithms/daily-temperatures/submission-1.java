class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayList<Integer> maxtemps = new ArrayList<>();
        int[] result = new int[temperatures.length];
        result[result.length-1] = 0;
        maxtemps.add(result.length-1);
        for (int i=temperatures.length-2; i>=0; i--){

            while(maxtemps.size() > 0 && temperatures[maxtemps.get(maxtemps.size()-1)] <= temperatures[i]){
                maxtemps.remove(maxtemps.size()-1);
            }

            if (maxtemps.size()==0){
                result[i] = 0;
            } else {
                result[i] = maxtemps.get(maxtemps.size()-1) - i;
            }

            maxtemps.add(i);
        }

        return result;
    }
}
