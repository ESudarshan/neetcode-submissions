class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), output);
        return new ArrayList<>(output);
    }

    public void backtrack(int[] nums, int i, List<Integer> subset, Set<List<Integer>> output) {
        if(i == nums.length) {
            output.add(new ArrayList<>(subset));
            return; 
        }
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, output);
        subset.remove(subset.size() - 1);

        backtrack(nums, i + 1, subset, output);
    }

}
