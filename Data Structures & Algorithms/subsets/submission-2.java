class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        subsets(nums, 0, nums.length, new HashSet(), output);
        return output;
    }

    public void subsets(int[] nums, int i, int n, Set<Integer> set, List<List<Integer>> output) {
        if(i == n) {
            output.add(new ArrayList(set));
            return;
        }
        set.add(nums[i]);
        subsets(nums, i + 1, n, set, output);
        set.remove(nums[i]);
        subsets(nums, i + 1, n, set, output);      
    }
}
