class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> perm : output) {
                for(int i=0; i<=perm.size(); i++) {
                    List<Integer> copy = new ArrayList<>(perm);
                    copy.add(i, num);
                    temp.add(copy);
                }
            }
            output = temp;
        }
        return output;
    }
}
