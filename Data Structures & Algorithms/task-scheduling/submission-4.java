class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();
        int time=0;

        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }

        while(!pq.isEmpty()) {
            List<Integer> remaining = new ArrayList<>();
            int ct= 0;

            for(int i=0; i<=n; i++) {

                if(!pq.isEmpty()) {
                    ct++;
                    int freq = pq.remove();
                    freq--;
                    if(freq > 0) {
                    remaining.add(freq);
                    }
                }
                
                else if(!remaining.isEmpty()) {
                    ct++;
                }
                
            }

            for(int task : remaining) {
                pq.add(task);
            }

            time += ct;
        }

        return time;
    }
}
