public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuffer sBuff = new StringBuffer();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sBuff.append("-");
        }
        
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        
        if(num > den) {
            while(num > den) {
                long reminder = num % den;
                sBuff.append(num / den);
                num = reminder;
            }
            if(num != 0) sBuff.append(".");
        } else {
            sBuff.append("0.");
        }
        
        
        Map<Long, Integer> reminderMap = new HashMap<Long, Integer>();
        while(num != 0) {
            if(reminderMap.containsKey(num)) {
                sBuff.insert(reminderMap.get(num), "(");
                sBuff.append(")");
                break;
            }
            
            reminderMap.put(num, sBuff.length());
            num *= 10;
            while(num < den) {
                sBuff.append("0");
                reminderMap.put(num, sBuff.length());
                num *= 10;
            }
            long reminder = num % den;
            sBuff.append(num / den);
            num = reminder;
        }
        
        return sBuff.toString();
    }
}