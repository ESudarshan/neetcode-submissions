class Solution {

    int[] mem;

    public int climbStairs(int n) {
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return climb(n);
    }

    public int climb(int n) {
        if(n >= 0 && mem[n] != -1) {
            return mem[n];
        }
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        mem[n] = climb(n - 1) + climb(n - 2);
        return mem[n];
    }
}
