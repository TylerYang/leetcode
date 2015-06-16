public class Solution {
    private final static char[] romanArr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
        if(num == 0) return "";
        StringBuffer romanBuff = new StringBuffer();
        int i = 0;
        while(num != 0){
            int currN = num % 10;
            StringBuffer currBuff = new StringBuffer();
            if(currN == 4) {
                currBuff.append(romanArr[i]);
                currBuff.append(romanArr[i + i]);
            } else if(currN == 9) {
                currBuff.append(romanArr[i]);
                currBuff.append(romanArr[i + 2]);
            } else {
                if(currN >= 5) {
                    currBuff.append(romanArr[i + 1]);
                    currN -= 5;    
                }
                while(currN > 0){
                    currBuff.append(romanArr[i]);
                    currN--;
                }
            }
            i += 2;
            num /= 10;
            romanBuff.insert(0, currBuff);// not very good solution
        }
        
        return romanBuff.toString();
    }
}
