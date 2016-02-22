import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>(n);
        for(int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < graph.size(); i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i : leaves) {
                //leave have only one edge
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if(graph.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void printArray(boolean[][] graph) {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int[][] edges = {
            {1, 0}, {1, 2}, {1, 3}
            //{1, 0}, {1, 2}, {2, 0}
            //{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        };
        System.out.println(sol.findMinHeightTrees(n, edges));
    }
}
