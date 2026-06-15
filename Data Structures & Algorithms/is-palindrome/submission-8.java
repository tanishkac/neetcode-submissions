class Solution {
    public boolean isPalindrome(String s) {
        String ss = s.toLowerCase();
        
        int l = 0;
        int r = ss.length() - 1;

        while(l<r) {
            while(l<r && !Character.isLetterOrDigit(ss.charAt(l))) {
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(ss.charAt(r))) {
                r--;
            }
            
            if(ss.charAt(l) != ss.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        } 

        return true;
    }
}
