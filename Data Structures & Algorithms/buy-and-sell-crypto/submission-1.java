class Solution {
    public int maxProfit(int[] prices) {
        
        // int bbd = 0;
        // int bsd = prices.length - 1;
        // int maxProfit = prices[bsd]-prices[bbd];
        // int profit;
        // while(bbd<bsd){
        //     for(int i=bbd + 1; i<=bsd; i++){
        //         profit = prices[i]-prices[bbd];
        //         maxProfit = Math.max(profit, maxProfit);
        //     }
        //     bbd++;
        // }
        // if(maxProfit > 0){
        //     return maxProfit;
        // } else {
        //     return 0;
        // }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;

    }
}


