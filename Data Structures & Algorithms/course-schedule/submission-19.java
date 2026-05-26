class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        for(int[] prereq : prerequisites) {
            map.computeIfAbsent(prereq[1], x -> new ArrayList<>()).add(prereq[0]);
            indeg[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            completed++;
            for(int dependent : map.getOrDefault(course, new ArrayList<>())) {
                indeg[dependent]--;
                if(indeg[dependent] == 0) {
                    q.add(dependent);
                }
            }
        }

        return numCourses == completed;
    }
}
