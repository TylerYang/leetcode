public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rlist = new ArrayList<List<Integer>>();
        if(root == null) return rlist;
        if(root.left == null && root.right == null && sum == root.val) {
            List<Integer> slist = new ArrayList<Integer>();
            slist.add(root.val);
            rlist.add(slist);
            return rlist;
        }
        if(root.left != null) {
            List<List<Integer>>sublist = pathSum(root.left, sum - root.val);
            if(sublist.size() != 0) {
                for(int i = 0; i < sublist.size(); i++) {
                    sublist.get(i).add(0, root.val);
                    rlist.add(sublist.get(i));
                }
            }
        }
        if(root.right != null) {
            List<List<Integer>>sublist = pathSum(root.right, sum - root.val);
            if(sublist.size() != 0) {
                for(int i = 0; i < sublist.size(); i++) {
                    sublist.get(i).add(0, root.val);
                    rlist.add(sublist.get(i));
                }
            }
        }
        return rlist;
    }
}