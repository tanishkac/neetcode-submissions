class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int tt = 0;

        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }

        while(!pq.isEmpty()) {
            Queue<Integer> q = new LinkedList<>();
            int ct = 0;

            for(int i=0; i<=n; i++) {
                if(!pq.isEmpty()) {
                    int taskf = pq.peek();
                    pq.remove();
                    taskf--;
                    ct++;

                    if(taskf > 0) {
                        q.add(taskf);
                    }
                }
            }

            while(!q.isEmpty()) {
                pq.add(q.remove());
            }

            if(pq.isEmpty()) {
                tt += ct;
            } else {
                tt += n+1;
            }

        }

        return tt;
        
    }
}
