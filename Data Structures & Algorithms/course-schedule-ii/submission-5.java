class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> inProgress = new HashSet<>();
    Set<Integer> completed = new HashSet<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

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

    public boolean isFinished(int[][] prereq, int course, Set<Integer> completed, List<Integer> output) {
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
        completed.add(course);
        map.remove(course);
        output.add(course);
        return true;
    }

}

