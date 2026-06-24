class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        combinationSum(nums, 0, target, new ArrayList<>(), output);
        return output;
    }

    public void combinationSum(int[] nums, int i, int target, List<Integer> combo, List<List<Integer>> output) {
        if(target == 0) {
            output.add(new ArrayList<>(combo));
            return;
        }

        if(i == nums.length || target < 0) {
            return;
        }
        
        combo.add(nums[i]);
        combinationSum(nums, i, target - nums[i], combo, output);
        combo.remove(combo.size() - 1);
        combinationSum(nums, i+1, target, combo, output);
    }
}
