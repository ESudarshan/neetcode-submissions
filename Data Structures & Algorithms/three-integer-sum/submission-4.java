/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
         Set<List<Integer>> ans = new HashSet<>();
         Arrays.sort(nums);
         for(int i =0; i<n; i++) {
            for(int j =i+1; j<n; j++) {
                for(int k =j+1; k<n; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        ans.add(triplet);
                    }
                }
            }   
         }
         return new ArrayList(ans);
    
    }
}
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return res;
    }
}