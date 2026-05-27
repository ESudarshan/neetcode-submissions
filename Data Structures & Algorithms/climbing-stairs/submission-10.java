class Solution {

    int[] mem;

    public int climbStairs(int n) {
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return climb(0, n);
    }

    public int climb(int c, int n) {
        if(c > n) {
            return 0;
        }
        if(c == n) {
            return 1;
        }
        if(mem[c] != -1) {
            return mem[c];
        }
        mem[c] = climb(c + 1, n) + climb(c + 2, n);
        return climb(c + 1, n) + climb(c + 2, n);
    }
}
