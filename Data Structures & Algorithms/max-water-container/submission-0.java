class Solution {
    public int maxArea(int[] heights) {
    
        //Brute force
        // int maxA = 0;
        // int area;
        // int n = heights.length;
        // for(int i=0; i<n-1; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(heights[i] < heights[j]){
        //             area = (j-i) * heights[i];
        //         } else {
        //             area = (j-i) * heights[j];
        //         }
        //         maxA = Math.max(maxA, area);
        //     }
        // }
        // return maxA;

        int n = heights.length;
        int left = 0;
        int right = n-1;
        int h;
        int width;
        int area;
        int maxA=0;
        while(left<right){
            h = Math.min(heights[left], heights[right]);
            width = right - left;
            area = h * width;
            maxA = Math.max(area, maxA);
            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxA;
    }
}
