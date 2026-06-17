class Solution {
    public int lengthOfLongestSubstring(String s) {
    

        int l = 0;
        int r = 0;
        int maxl = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(r<s.length()) {   
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            
            if(map.get(s.charAt(r)) > 1) {
                while(s.charAt(l) != s.charAt(r)) {
                    map.remove(s.charAt(l));
                    l++;
                } 
                map.put(s.charAt(l), 1);
                l++;
            }

            maxl = Math.max(maxl, r-l+1); 
            r++;     
        }
        return maxl;
    }
}
