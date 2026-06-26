class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums, 0, output);
        return output;
    }

    public void backtrack(int[] nums, int i, List<List<Integer>> output) {
        if(i == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for(int num :nums) {
                perm.add(num);
            }
            output.add(perm);
            return;
        }

        for(int k=i; k<nums.length; k++) {
            swap(nums, i, k);
            backtrack(nums, i+1, output);
            swap(nums, i, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
