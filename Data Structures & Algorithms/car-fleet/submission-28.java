class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<int[]> cars = new ArrayList<>();

        for(int i=0; i<n; i++) {
            cars.add(new int[] {target-position[i], speed[i]});
        }

        Collections.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
         
        Double prevFleetTime = ((double)cars.get(0)[0])/cars.get(0)[1];
        int fleets = 1;
        for(int i=1; i<n; i++) {
            double currFleetTime = ((double)cars.get(i)[0])/cars.get(i)[1];
            if(prevFleetTime < currFleetTime) {
                fleets++;
                prevFleetTime = currFleetTime;
            }
        }
        return fleets;

    }
}
