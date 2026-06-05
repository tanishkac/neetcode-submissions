class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int k=1;
        int res=0;
        
        int l=1;
        int r=piles[piles.length - 1];

        while(l<=r) {

            k= l + (r - l) / 2;
            int hours = 0;

            for(int pile : piles) {
                hours += pile/k;
                if((pile % k) !=0) {
                    hours += 1;
                }
            }

            if(hours<=h) {
                r = k-1;
                res = k;
            } else {
                l = k+1;
            }

        }

        return res;
    }
}