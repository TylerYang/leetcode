public class Solution2 {
    private final static char[] romanArr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
        if(num == 0) return "";
        StringBuffer romanBuff = new StringBuffer();
        int base = getBase(num); 
        int i = (int)Math.log10(base) * 2;
        while(num != 0){
            int currN = num / base;
            if(currN == 4) {
                romanBuff.append(romanArr[i]);
                romanBuff.append(romanArr[i + i]);
            } else if(currN == 9) {
                romanBuff.append(romanArr[i]);
                romanBuff.append(romanArr[i + 2]);
            } else {
                if(currN >= 5) {
                    romanBuff.append(romanArr[i + 1]);
                    currN -= 5;    
                }
                while(currN > 0){
                    romanBuff.append(romanArr[i]);
                    currN--;
                }
            }
            i += 2;
            num %= base;
            base /= 10;
        }
        
        return romanBuff.toString();
    }
    private int getBase(int num){
        int count = 1;
        while(num > 9) {
            num /= 10;
            count *= 10;
        }
        return count;
    }
}
