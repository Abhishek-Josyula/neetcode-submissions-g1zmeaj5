class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];

        for (int i=0; i<position.length; i++){
            posSpeed[i] = new int[3];
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }

        Arrays.sort(posSpeed, (a,b) -> a[0]-b[0]);

        ArrayList<Double> g = new ArrayList<>();
        for (int i=posSpeed.length-1; i>=0; i--){
            if (g.size()==0){
                g.add((double)(target-posSpeed[i][0])/posSpeed[i][1]);
            }else{
                int[] curr = posSpeed[i];
                double prevt = g.get(g.size()-1);
                double currt = (double)(target-curr[0])/curr[1];
                if (prevt < currt){
                    g.add(currt);
                }
            }
        }

        return g.size(); 
    }
}
