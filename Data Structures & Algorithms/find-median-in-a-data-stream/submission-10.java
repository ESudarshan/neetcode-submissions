class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!left.isEmpty() && num < left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if(left.size() == right.size() + 2) {
            right.offer(left.poll());
        } else if(left.size() + 2 == right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()) {
            return left.peek();
        } 
        if(left.size() < right.size()) {
                return right.peek();
        }
        return (double)(left.peek() + right.peek()) / 2;
    }
}
