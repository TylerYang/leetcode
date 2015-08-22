public class Solution {
    boolean[] mark;
    boolean[] onStack;
    boolean[][] graph;
    Stack<Integer> stack;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort
        graph = new boolean[numCourses][numCourses];
        mark = new boolean[numCourses];
        onStack = new boolean[numCourses];
        
        stack = new Stack<Integer>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        
        for(int i = 0; i < graph.length; i++) {
            if(!mark[i] && !dfs(i)) {
                return new int[0];
            }
        }
        
        int[] courseOrder = new int[numCourses];
        int i = numCourses - 1;
        while(stack.empty() == false) {
            courseOrder[i--] = stack.pop();
        }
        
        return courseOrder;
    }
    private boolean dfs(int i) {
        mark[i] = true;
        onStack[i] = true;
        
        for(int j = 0; j < graph[i].length; j++) {
            if(graph[i][j] == true){
                if(!mark[j]) {
                    if(!dfs(j)) return false;
                } else if(onStack[j]) {
                    return false;
                }
            }
        }
        
        onStack[i] = false;
        stack.push(i);
        
        return true;
    }
}