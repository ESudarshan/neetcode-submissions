class Solution {
    public List<List<Integer>> permute(int[] nums) {
/*
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
*/

        List<List<Integer>> output = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(nums, visited, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(int[] nums, int[] visited, List<Integer> perm, List<List<Integer>> output) {
        if(perm.size() == nums.length) {
            output.add(new ArrayList<>(perm));
            return;
        }

        for(int k=0; k<nums.length; k++) {
            if(visited[k] == 0) {
                visited[k] = 1;
                perm.add(nums[k]);
                backtrack(nums, visited, perm, output);
                perm.remove(perm.size() - 1);
                visited[k] = 0;
            }
        }

    }

}
