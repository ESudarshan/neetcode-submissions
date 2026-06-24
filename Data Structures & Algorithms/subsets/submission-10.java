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
    }
}
