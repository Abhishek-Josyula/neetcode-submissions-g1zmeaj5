class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxprofit = 0;
        for (int i=0; i<prices.length; i++){
            int profit = prices[i] - minBuy;

            if (prices[i]<minBuy){
                minBuy = prices[i];
            }

            if(profit>maxprofit){
                maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
