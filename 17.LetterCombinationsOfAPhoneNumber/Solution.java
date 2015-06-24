import java.util.List;
import java.util.ArrayList;
public class Solution {
    private String[] letterArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        return getLetterCombinations(digits, 0);
    }
    private List<String> getLetterCombinations(String digits, int start){
        List<String> rList = new ArrayList<String>();
        int i = (int)digits.charAt(start) - (int)'0';
        String currStr = letterArr[i];
        if(start == digits.length() - 1){
            for(int j = 0; j < currStr.length(); j++) {
                rList.add(currStr.substring(j, j + 1));
            } 
            return rList;
        }
        
        List<String> subList = getLetterCombinations(digits, start + 1);
        
        for(int j = 0; j < currStr.length(); j++){
            String s = currStr.substring(j, j + 1);
            for(int k = 0; k < subList.size(); k++) {
                rList.add(s + subList.get(k));
            }
        }
        return rList;
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        String digits = "23";
        System.out.println(sol.letterCombinations(digits));
    }
}
