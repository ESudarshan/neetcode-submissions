class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> output) {
        if(i == nums.length) {
            output.add(new ArrayList<>(subset));
            return; 
        }
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, output);
        subset.remove(subset.size() - 1);
        while((i + 1) < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, i + 1, subset, output);
    }

}
