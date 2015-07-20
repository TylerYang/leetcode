public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    private List<TreeNode> genTrees(int L, int R) {
        List<TreeNode> rList = new ArrayList<TreeNode>();
        if(L >= R) {
            TreeNode node = null;
            if(L == R) node = new TreeNode(L);
            rList.add(node);
            return rList;
        } else {
            for(int i = L; i <= R; i++) {
                if(i == L || i == R) {
                    List<TreeNode> sublist;
                    sublist = i == L ? genTrees(i + 1, R) : genTrees(L, i - 1);
                    for(int j = 0; j < sublist.size(); j++) {
                        TreeNode node = new TreeNode(i);
                        if(i == L) {
                            node.right = sublist.get(j);    
                        } else {
                            node.left = sublist.get(j);
                        }
                        rList.add(node);
                    }
                } else {
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
        }
        return rList;
    }
}