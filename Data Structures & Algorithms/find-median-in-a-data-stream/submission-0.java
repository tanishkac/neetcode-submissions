class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) {
            max.offer(num);
        }
        else {
            min.offer(num);
        }

        if(max.size() - min.size() > 1) {
            min.offer(max.remove());
        }
        else if(min.size() - max.size() > 1) {
            max.offer(min.remove());
        }
    }
    
    public double findMedian() {
        if(min.size() > max.size()) {
            return min.peek();
        }
        else if(min.size() < max.size()) {
            return max.peek();
        }
        else {
            return (double)(max.peek() + min.peek()) / 2 ;
        }
    }
}
