public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    private List<TreeNode> genTrees(int L, int R) {
        List<TreeNode> rList = new ArrayList<TreeNode>();
        if(L > R) {
            rList.add(null);
            return rList;
        } else {
            for(int i = L; i <= R; i++) {
                List<TreeNode> leftList = genTrees(L, i - 1);
                List<TreeNode> rightList = genTrees(i + 1, R);
                for(int j = 0; j < leftList.size(); j++) {
                    for(int k = 0; k < rightList.size(); k++) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftList.get(j);
                        node.right = rightList.get(k);
                        rList.add(node);
                    }
                }
            }
        }
        return rList;
    }
}