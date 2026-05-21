class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> output = new HashSet<>();
        combinationSum(nums, 0, target, new ArrayList<>(), output);
        return new ArrayList<>(output);
    }

    public void combinationSum(int[] nums, int i, int target, List<Integer> combo, Set<List<Integer>> output) {
        if(i == nums.length || target < 0) {
            return;
        }
        
        if(target == 0) {
            output.add(new ArrayList<>(combo));
            return;
        }

        combo.add(nums[i]);
        combinationSum(nums, i, target - nums[i], combo, output);
        // combinationSum(nums, i+1, target - nums[i], combo, output);
        combo.remove(combo.size() - 1);
        combinationSum(nums, i+1, target, combo, output);
    }
}
