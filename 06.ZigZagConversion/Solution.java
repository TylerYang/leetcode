public class Solution{
    public String convert(String s, int numRows){
        if(numRows == 1) return s;
        StringBuffer[] strBuffArr = new StringBuffer[numRows];
        int p = 0, offset = -1;
        for(int i = 0; i < s.length(); i++){
            if(p == 0 || p == numRows - 1){
               offset *= -1; 
            }
            if(strBuffArr[p] == null){
                strBuffArr[p] = new StringBuffer();
            }  
            strBuffArr[p].append(s.charAt(i));
            p += offset;
        }

        for(int i = 1; i < numRows && strBuffArr[i] != null; i++){
            strBuffArr[0].append(strBuffArr[i]);
        }
        return strBuffArr[0].toString(); 
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String input = "PAYPALISHIRING";
        System.out.println(sol.convert(input, 3));
    }
}
