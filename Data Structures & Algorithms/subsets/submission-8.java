class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList());
        for(int num : nums) {
            int n = output.size();
            for(int i=0; i<n; i++) {
                List<Integer> newSubset =  new ArrayList<>(output.get(i));
                newSubset.add(num);
                output.add(newSubset);
            }
        }
        return output;
/*
        List<List<Integer>> output = new ArrayList<>();
        subsets(nums, 0, nums.length, new ArrayList(), output);
        return output;
*/        
    }

    public void subsets(int[] nums, int i, int n, List<Integer> list, List<List<Integer>> output) {
        if(i == n) {
            output.add(new ArrayList(list));
            return;
        }
        list.add(nums[i]);
        subsets(nums, i + 1, n, list, output);
        list.remove(list.size() - 1);
        subsets(nums, i + 1, n, list, output);      
    }
}
