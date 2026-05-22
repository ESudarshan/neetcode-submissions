class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), output);
        return new ArrayList<>(output);
    }

    public void backtrack(int[] candidates, int i, int target, List<Integer> combo, List<List<Integer>> output) {
        if(target == 0) {
            output.add(new ArrayList<>(combo));
            return;
        }
        for(int j=i; j<candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j-1]) {
                continue;
            }
            if(target - candidates[j] < 0) {
                break;
            }
            combo.add(candidates[j]);
            backtrack(candidates, j+1, target - candidates[j], combo, output);
            combo.remove(combo.size() - 1);
        }
    }
}
