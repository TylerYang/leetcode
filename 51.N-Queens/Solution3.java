public class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] mark = new int[n];
        List<List<String>> result = new ArrayList<List<String>>();
        nQueens(result, mark, 0);
        return result;
    }
    private void nQueens(List<List<String>> result, int[] mark, int level) {
        int n = mark.length;
        for (int i = 0; i < n; i++) {
            if (isMarkable(mark, level, i) == false) continue;

            mark[level] = i;
            if (level == n - 1) {
                result.add(genCharts(mark));
            } else {
                nQueens(result, mark, level + 1);
            }
        }
    }
    private boolean isMarkable(int[] mark, int x, int y) {
        int inter = x - y, sum = x + y;
        for (int i = x - 1; i >= 0; i--) {
            int j = mark[i];
            if(y == j) return false;
            if(i - j == inter && j < y) return false;
            if(i + j == sum && j > y) return false;
        }
        return true;
    }
    private List<String> genCharts(int[] marks) {
        List<String> list = new ArrayList<String>();
        int n = marks.length;
        StringBuffer sBuff;
        for (int i = 0; i < n; i++) {
            sBuff = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (j == marks[i]) {
                    sBuff.append('Q');
                } else {
                    sBuff.append('.');
                }
            }
            list.add(sBuff.toString());
        }
        return list;
    }
}
