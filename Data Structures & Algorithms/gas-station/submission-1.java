class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int res = -1;
        for(int i=0; i<n; i++) {
            int start = i;
            int count = 0;
            int remGas = 0;
            while(count < n) {
                remGas += gas[start];
                if(cost[start] > remGas) {
                    break;
                }
                remGas -= cost[start];
                start = (start + 1) % n;
                count++;
            }
            if(count == n) {
                return i;
            }
        }
        return -1;
    }
}
