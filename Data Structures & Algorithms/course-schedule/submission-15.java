class Solution {

    Set<Integer> inProgress = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        for(int i=0; i<n; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }
        for(int i=1; i<=numCourses; i++) {
            inProgress.clear();
            if(!isFinished(prerequisites, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFinished(int[][] prereq, int course) {
        if(!map.containsKey(course)) {
            return true;
        }
        if(inProgress.contains(course)) {
            return false;
        }
        inProgress.add(course);
        List<Integer> dependencies = map.getOrDefault(course, new ArrayList<>());
        for(int dependency : dependencies) {
            if(!isFinished(prereq, dependency)) {
                return false;
            }
        }
        return true;
    }

}
