class Solution {

    Set<Integer> inProgress = new HashSet<>();
    Set<Integer> completed = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }
        for(int i=0; i<numCourses; i++) {
            if(!isFinished(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFinished(int course) {
        if(completed.contains(course)) {
            return true;
        }
        if(!map.containsKey(course)) {
            return true;
        }
        if(inProgress.contains(course)) {
            return false;
        }
        inProgress.add(course);
        List<Integer> dependencies = map.get(course);
        for(int dependency : dependencies) {
            if(!isFinished(dependency)) {
                return false;
            }
        }
        inProgress.remove(course);
        completed.add(course);
        return true;
    }

}
