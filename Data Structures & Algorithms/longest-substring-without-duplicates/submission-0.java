class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1); 
            } 

            map.put(ch, i);

            longest = Math.max(longest, i - left + 1);
        }
        
        return longest;

    }
}
