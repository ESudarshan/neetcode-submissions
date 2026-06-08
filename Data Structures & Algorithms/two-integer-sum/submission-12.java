class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;

        int[][] numsi = new int[n][2];
        for(int i=0; i<n; i++) {
            numsi[i][0] = nums[i];
            numsi[i][1] = i;
        }

        Arrays.sort(numsi, (a, b) -> Integer.compare(a[0], b[0]));

        int l=0;
        int r=n-1;
        while(l < r) {
            int sum = numsi[l][0] + numsi[r][0];
            if(sum == target) {
                return new int[] {Math.min(numsi[l][1], numsi[r][1]), Math.max(numsi[l][1], numsi[r][1])};
            } else if(sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[0];
    }
}
