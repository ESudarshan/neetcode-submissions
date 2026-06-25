class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num : nums) {
            List<List<Integer>> newop = new ArrayList<>();
            for(List<Integer> perm : output) {
                for(int i=0; i<=perm.size(); i++) {
                    List<Integer> newperm = new ArrayList(perm);
                    newperm.add(i, num);
                    newop.add(newperm);
                }
            }
            output = newop;
        }
        return output;
        
    }
}
