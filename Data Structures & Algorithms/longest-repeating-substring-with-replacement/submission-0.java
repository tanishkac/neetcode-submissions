class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0; //left pointer
        int lvw = 0; //longest valid window
        int ctbr = 0; //charaters to be replaced
        int maxf = 0; 

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxf = Math.max(maxf, map.get(ch));
            ctbr = i - l + 1 - maxf;

            while(ctbr > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                ctbr = i - l + 1 - maxf;
            }

            lvw = Math.max(lvw, i - l + 1);
            
        }

        return lvw;
        
    }
}
