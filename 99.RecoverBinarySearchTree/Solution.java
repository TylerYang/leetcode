public class Solution {
	public void recoverTree(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> rStack = new Stack<TreeNode>();
		TreeNode n1 = null, n2 = null, prevNode = root.left == null ? root : null;
		while(root != null) {
			rStack.push(root);
			root = root.left;
		}
		while(rStack.empty() == false) {
			TreeNode curr = rStack.pop();
			TreeNode node = curr.right;
			while(node != null) {
				rStack.push(node);
				node = node.left;
			}
			if(n1 == null && rStack.empty() == false && rStack.peek().val < curr.val) n1 = curr;
			if(prevNode != null && prevNode.val > curr.val) n2 = curr;
			prevNode = curr;
		}
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
		return;
	}
}
