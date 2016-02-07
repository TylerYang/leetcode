public class Solution {
    int[][] paths;
    int count;
    int[] v = {1, 0, -1, 0};
    int[] h = {0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
      if(matrix.length == 0) return 0;
      if(matrix[0].length == 0) return 0;
      count = 1;
      paths = new int[matrix.length][matrix[0].length];
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
          dfs(matrix, i, j);
        }
      }
      return count;
    }
    public int dfs(int[][] matrix, int i, int j) {
      if(paths[i][j] != 0) return paths[i][j];
      int path = 1;
      for(int k = 0; k < 4; k++) {
        int x = i + v[k], y = j + h[k];
        if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
          int tmp = dfs(matrix, x, y);
          if(tmp >= path) path = tmp + 1;
        }
      }
      paths[i][j] = path;
      if(path > count) count = path;
      return path;
    }
}
