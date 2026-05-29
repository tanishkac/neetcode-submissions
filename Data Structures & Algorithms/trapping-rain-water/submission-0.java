class Solution {
    public int trap(int[] height) {
        int water=0;
        int h=0;
        int leftM = height[0];
        int[] rightM = new int[height.length];
        rightM[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightM[i] = Math.max(height[i], rightM[i+1]);
        }


        for(int i=0; i<height.length; i++){
            
            leftM = Math.max(leftM, height[i]);
            
            h = Math.min(leftM, rightM[i]) - height[i];
            
            water = water+h;
        }
        return water;
    }
}
