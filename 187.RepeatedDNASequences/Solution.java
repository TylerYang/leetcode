public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rList = new ArrayList<String>();
        
        Set<Integer> strSet = new HashSet<Integer>();
        Set<Integer> listSet = new HashSet<Integer>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            int subKey = getInteger(subStr);
            
            if(strSet.contains(subKey) && !listSet.contains(subKey)) {
                rList.add(subStr);
                listSet.add(subKey);
            } else {
                strSet.add(subKey);
            }
        }
        
        return rList;
    }
    public int getInteger(String s) {
        int hash = 0;
        for(int i = 0; i < s.length(); i++) {
            hash = hash << 2 | getNumber(s.charAt(i));
        }
        
        return hash;
    }
    private int getNumber(char s) {
        switch(s) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
            default:
                return 3;
        }
    }
}