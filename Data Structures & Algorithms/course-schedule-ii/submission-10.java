class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] output = new int[numCourses];
        
        int[] indeg = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
            indeg[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        
        int k = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            output[k] = course;
            k++;
            for(int dependent : graph.getOrDefault(course, new ArrayList<>())) {
                indeg[dependent]--;
                if(indeg[dependent] == 0) {
                    q.add(dependent);
                }
            }
        }

        return k == numCourses ? output : new int[0];
    }
}
