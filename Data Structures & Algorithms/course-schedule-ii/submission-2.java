class Solution {

    Set<Integer> inProgress = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<Integer> output = new ArrayList<>();
        List<Integer> completed = new ArrayList<>();
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }
        for(int i=0; i<numCourses; i++) {
            if(!isFinished(prerequisites, i, completed, output)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        for(int c : output) {
            ans[i++] = c;
        }

        return ans;
    }

    public boolean isFinished(int[][] prereq, int course, List<Integer> completed, List<Integer> output) {
        if(completed.contains(course)) {
            return true;
        }
        if(inProgress.contains(course)) {
            return false;
        }
        inProgress.add(course);
        List<Integer> dependencies = map.getOrDefault(course, new ArrayList<>());
        for(int dependency : dependencies) {
            if(!isFinished(prereq, dependency, completed, output)) {
                return false;
            }
        }
        inProgress.remove(course);
        map.remove(course);
        completed.add(course);
        output.add(course);
        return true;
    }

}

