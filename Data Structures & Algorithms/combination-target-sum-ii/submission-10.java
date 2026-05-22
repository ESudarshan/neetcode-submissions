class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), output);
        return new ArrayList<>(output);
    }

    public void backtrack(int[] candidates, int i, int target, List<Integer> combo, Set<List<Integer>> output) {
        if(target == 0) {
            output.add(new ArrayList<>(combo));
            return;
        }

        if(i == candidates.length || target < 0) {
            return;
        }

        combo.add(candidates[i]);
        backtrack(candidates, i + 1, target - candidates[i], combo, output);
        combo.remove(combo.size() - 1);
        while((i+1) < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        backtrack(candidates, i + 1, target, combo, output);
    }
}
