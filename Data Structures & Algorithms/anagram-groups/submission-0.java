class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            char[] word = str.toCharArray();

            Arrays.sort(word);

            String key = new String(word);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            } 

            map.get(key).add(str);
        }

        return new ArrayList<List<String>>(map.values());
        
        
    }
}
