class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;
        int r = prices.length - 1;
        int l = 0;

        while(r>0) {
            
            while(l<r) {
                max = Math.max(max, prices[r]-prices[l]);
                l++;
            }
            r--;
            l=0;
        }

        return max;

    }
}
