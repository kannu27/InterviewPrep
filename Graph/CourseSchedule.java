//https://leetcode.com/problems/course-schedule
//https://leetcode.com/problems/course-schedule/discuss/224540/Java-Topo.-Sort-Solution-and-DFS-Solution-with-good-writeups.


class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 2) return true;
        HashMap<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        
        //Build graph O(E + V)
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++; 
        }
         //Topo sort graph O(E + V)
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){ 
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            for(Integer neigh : graph.get(course)){
                if(--indegree[neigh] == 0) queue.offer(neigh);
            }
            graph.remove(course);
        }
        
        return graph.isEmpty();
    }
    
    
}
