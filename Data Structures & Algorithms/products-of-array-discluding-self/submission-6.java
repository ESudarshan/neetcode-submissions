class Solution {
    public int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));
        
        int[] left = new int[nums.length];
        int prefixSum = 1;
        left[0] = prefixSum;
        for(int i=1; i<nums.length; i++) {
            prefixSum = prefixSum * nums[i-1];
            left[i] = prefixSum;
        }
        System.out.println(Arrays.toString(left));

        int suffiuxSum = 1;
        for(int i=nums.length-2; i>=0; i--) {
            suffiuxSum = suffiuxSum * nums[i+1];
            left[i] = left[i] * suffiuxSum;
        }
        System.out.println(Arrays.toString(left));

        return left;
    }
}  
