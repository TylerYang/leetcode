import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<String> generateParenthesis(int n) {
        return genParenthesis(n, n);
    }
    private List<String> genParenthesis(int leftN, int rightN) {
        List<String> rList = new ArrayList<String>();
        if(leftN == 0) {
            String rightStr = getRightParenthesis(rightN);
            rList.add(rightStr);
            return rList;
        }
        List<String> subList = genParenthesis(leftN - 1, rightN);
        for(int i = 0; i < subList.size(); i++) {
            rList.add("(" + subList.get(i));
        }
        if(leftN < rightN){
            subList = genParenthesis(leftN, rightN - 1);
            for(int i = 0; i < subList.size(); i++){
                rList.add(")" + subList.get(i));
            }
        }
        return rList;
    }
    private String getRightParenthesis(int count) {
        StringBuffer sBuffer = new StringBuffer();
        for(int i = 0; i < count; i++) {
            sBuffer.append(")");
        }
        return sBuffer.toString();
    }
}
