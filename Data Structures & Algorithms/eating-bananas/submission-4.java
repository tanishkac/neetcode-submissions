class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max=0;
        
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int k=0;
        int l=1;
        int r=max;

        while(l<=r) {

            int mid = l + ((r-l)/2);
            int hours = 0;
            for(int pile : piles) {
                hours += ((pile - 1)/mid) + 1;
            }

            if(hours <= h) {
                k = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }

        }

        return k;
    }
}
