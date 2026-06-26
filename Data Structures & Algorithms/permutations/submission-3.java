class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums, new LinkedHashSet<>(), output);
        return output;
    }

    public void backtrack(int[] nums, Set<Integer> perm, List<List<Integer>> output) {
        if(perm.size() == nums.length) {
            output.add(new ArrayList<>(perm));
            return;
        }

        for(int k=0; k<nums.length; k++) {
            if(!perm.contains(nums[k])) {
                perm.add(nums[k]);
                backtrack(nums, perm, output);
                perm.remove(nums[k]);
            }
        }
    }

}
