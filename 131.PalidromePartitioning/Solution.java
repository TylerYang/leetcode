public class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return new ArrayList<List<String>>();
        return genPalindromeList(s, 0);
    }
    private List<List<String>> genPalindromeList(String s, int start) {
        List<List<String>> list = new ArrayList<List<String>>();
        if (start == s.length() - 1) {
            list.add(new ArrayList<String>(Arrays.asList(s.substring(start))));
            return list;
        }
        for(int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                if (end == s.length() - 1) {
                    list.add(new ArrayList<String>(Arrays.asList(s.substring(start))));
                } else {
                    List<List<String>> subList = genPalindromeList(s, end + 1);
                    if (subList.size() > 0) {
                        String currStr = s.substring(start, end + 1);
                        for(List<String> paliList: subList) {
                            paliList.add(0, currStr);
                            list.add(paliList);
                        }
                    }
                }
            }
        }
        return list;
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
