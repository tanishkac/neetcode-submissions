class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] window = new int[26];
        int l = 0;

        for(int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i)- 'a']++;
        }

        for(int i=0; i<s2.length(); i++) { 

            window[s2.charAt(i) - 'a']++;

            if(i-l+1 > s1.length()) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }
            
            if(i-l+1 == s1.length()) {
                if(Arrays.equals(window, s1Count)){
                    return true;
                }
            }
        }

        return false;
        
    }
}
