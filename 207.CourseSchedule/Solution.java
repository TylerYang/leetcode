public class Solution {
    boolean[][] graph;
    boolean[] mark, onStack;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        mark = new boolean[numCourses];
        onStack = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if(!mark[i] && dfs(i) == false) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int i) {
        mark[i] = true;
        onStack[i] = true;
        for(int j = 0; j < graph.length; j++) {
            if(graph[i][j] == true) {
                if(mark[j] == false) {
                    if(dfs(j) == false) return false;
                } else if(onStack[j] == true) {
                    return false;
                }
            }
        }
        onStack[i] = false;
        
        return true;
    }
}