public class Solution {
    int[][] paths;
    int count;
    public int longestIncreasingPath(int[][] matrix) {
      if(matrix.length == 0) return 0;
      if(matrix[0].length == 0) return 0;
      count = 1;
      paths = new int[matrix.length][matrix[0].length];
      System.out.println("wtf:" + matrix[0].length);
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
          int path = 1;
          if(i != 0 && matrix[i - 1][j] > matrix[i][j]) {
            int tmp = calPath(matrix, i - 1, j);
            if(tmp >= path) path = tmp + 1;
          }
          if(i != matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            int tmp = calPath(matrix, i + 1, j);
            if(tmp >= path) path = tmp + 1;
          }
          if(j != 0 && matrix[i][j - 1] > matrix[i][j]) {
            int tmp = calPath(matrix, i, j - 1);
            if(tmp >= path) path = tmp + 1;
          }
          if(j != matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            int tmp = calPath(matrix, i, j + 1);
            if(tmp >= path) path = tmp + 1;
          }
          paths[i][j] = path;
          if(path > count) count = path;
        }
      }
      return count;
    }
    public int calPath(int[][] matrix, int i, int j) {
      System.out.println("i:" + i + " ,j:" + j);
      if(paths[i][j] != 0) return paths[i][j];
      int path = 1;
      if(i != 0 && matrix[i - 1][j] > matrix[i][j]) {
        int tmp = calPath(matrix, i - 1, j);
        if(tmp >= path) path = tmp + 1;
      }
      if(i != matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
        int tmp = calPath(matrix, i + 1, j);
        if(tmp >= path) path = tmp + 1;
      }
      if(j != 0 && matrix[i][j - 1] > matrix[i][j]) {
        int tmp = calPath(matrix, i, j - 1);
        if(tmp >= path) path = tmp + 1;
      }
      if(j != matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
        int tmp = calPath(matrix, i, j + 1);
        if(tmp >= path) path = tmp + 1;
      }
      paths[i][j] = path;
      if(path > count) count = path;
      return path;
    }
}
