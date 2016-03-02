import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
public class Codec {
    private String emptyEle = "!";
    public String serialize(TreeNode root) {
        if(root == null) return emptyEle;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        List<String> list = new LinkedList<String>();
        StringBuffer sBuff = new StringBuffer();
        while(queue.size() != 0) {
            TreeNode node = queue.poll();
            if(node.val == Integer.MIN_VALUE) {
                //sBuff.append("null");
                list.add(emptyEle);
            } else {
                // sBuff.append(node.val);
                list.add(String.valueOf(node.val));
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if(leftNode == null) {
                    leftNode = new TreeNode(Integer.MIN_VALUE);
                }
                if(rightNode == null) {
                    rightNode = new TreeNode(Integer.MIN_VALUE);
                }
                queue.offerLast(leftNode);
                queue.offerLast(rightNode);
            }
            // if(queue.size() != 0) sBuff.append(",");
        }
        for(int i = list.size() - 1; i > 0; i--) {
            if(emptyEle.equals(list.get(i))) {
                list.remove(i);
            } else {
                break;
            }
        }
        for(int i = 0; i < list.size(); i++) {
            sBuff.append(list.get(i));
            if(i != list.size() - 1) sBuff.append(",");
        }
        return sBuff.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        if(data.length() == 1 && emptyEle.equals(data)) return null;

        String[] strArr = data.split(",");
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();

        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        queue.add(root);
        for(int i = 1; i < strArr.length; i++) {
            TreeNode node = queue.poll();
            String str = strArr[i];
            if(emptyEle.equals(str) == false) {
                node.left = new TreeNode(Integer.parseInt(str));
                queue.offerLast(node.left);
            }
            i++;
            if(i < strArr.length && emptyEle.equals(strArr[i]) == false) {
                node.right = new TreeNode(Integer.parseInt(strArr[i]));
                queue.offerLast(node.right);
            }
        }
        return root;
    }
}
