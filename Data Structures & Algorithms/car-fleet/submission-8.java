class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

       int fleets = position.length;
       HashMap<Integer, Float> map = new HashMap<>();
       

       for(int i = 0; i<fleets; i++) {
            int x = position[i];
            float t = (float) (target - x)/speed[i];
            map.put(x, t);
       }

        Arrays.sort(position);
        
        Stack<Integer> stack = new Stack<>();

        for(int pos : position) {
            stack.push(pos);
        }

        float eta = 0;
        while(!stack.empty()) {
            int car = stack.peek();
            if(map.get(car) > eta) {
                eta = map.get(car);
            } else {
                fleets--;
            }
            stack.pop(); 
        }

       return fleets;
    }
}
