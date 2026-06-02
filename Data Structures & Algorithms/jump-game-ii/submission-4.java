class Solution {

    int[] mem;

    public int jump(int[] nums) {
        int n= nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        return minJumps(nums, 0, n);
    }

    int minJumps(int[] nums, int i, int n) {
        if(i == n-1) {
            return 0;
        }
        if(mem[i] != -1) {
            return mem[i];
        }
        int minJumps = n;
        for(int k=1; k<=nums[i] && (i+k)<n; k++) {
            minJumps = Math.min(minJumps, 1 + minJumps(nums, i+k, n));
        }
        mem[i] = minJumps;
        return minJumps;
    }
}
