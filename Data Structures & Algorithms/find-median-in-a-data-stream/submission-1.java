class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        int n = list.size();
        int pos = n;
        for(int i=0; i<n; i++) {
            if(num < list.get(i)) {
                pos = i;
                break;
            }
        }
        if(pos == n) {
            list.add(num);
        } else {
            list.add(pos, num);
        }
    }
    
    public double findMedian() {
        int size = list.size();
        if(size % 2 == 1) {
            return list.get(size/2);
        }
        return (double)(list.get(size/2) + list.get((size/2)-1)) / 2;
    }
}
