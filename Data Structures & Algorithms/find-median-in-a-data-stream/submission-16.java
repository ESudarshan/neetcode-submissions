class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!right.isEmpty() && num >= right.peek()) {
            right.offer(num);
        } else {
            left.offer(num);
        }

        if(right.size() - left.size() == 2) {
            left.offer(right.poll());
        } 
        
        if(left.size() - right.size() == 2) {
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()) {
            return left.peek();
        } 
        if(left.size() < right.size()) {
            return right.peek();
        }
        return left.peek() / 2.0 + right.peek() / 2.0;
    }
}
