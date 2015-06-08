public class SolutionDP{
    //Dynamic Programming solution
    public String longestPalindromeSubstring(String str){
        int strLen = str.length();
        boolean[][] palin = new boolean[strLen][strLen];
        int max = 0, start = 0, end = 0;
        for(int i = strLen; i >= 0; i--){
            for(int j = i; j < strLen; j++){
                if(str.charAt(i) == str.charAt(j) && (j - i <= 2 || palin[i+1][j-1] == true)){
                    palin[i][j] = true;
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        start = i;
                        end = j + 1;
                    }   
                }
            }
        }

        return str.substring(start, end);
    }
    public static void main(String[] args){
        String input = "abbaccxyz";
        SolutionDP sol = new SolutionDP();
        System.out.println(sol.longestPalindromeSubstring(input));
        
    }
}
