class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++) {
            start = 0;
            if(i>0 && nums[i] == nums[i-1]) {
                start = end;
            }
            end = output.size();
            for(int j=start; j<end; j++) {
                List<Integer> newList = new ArrayList<>(output.get(j));
                newList.add(nums[i]);
                output.add(newList);
            }
        }
        return output;
    }
}
