class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<int[]> cars = new ArrayList<>();

        for(int i=0; i<n; i++) {
            cars.add(new int[] {target-position[i], speed[i]});
        }

        Collections.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
               
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            double time = ((double)cars.get(i)[0])/cars.get(i)[1];
            if(stack.isEmpty() || stack.peek().compareTo(time) < 0) {
                stack.push(time);
            }
        }
        
        return stack.size();        
    }
}
