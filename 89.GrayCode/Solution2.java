public class Solution2 {
    public List<Integer> grayCode(int n ) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for (int i = 0; i < n; i++){
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                list.add(list.get(j) | 1 << i);
            }
        }
        return list;
    }
}
