public class Solution {
    private final static String[] divArr = {"", "Thousand", "Million", "Billion"};
    private final static String[][] numArr = {
        {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"},
        {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen"},
        {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}
    };

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int divCount = 0;
        StringBuffer sb = new StringBuffer();
        while(num > 0) {
            StringBuffer tmpSB = new StringBuffer();

            int tmpNum = num % 1000;
            if(tmpNum != 0) {
                tmpSB.append(numToWords(num % 1000));
                tmpSB.append(" ");
                tmpSB.append(divArr[divCount]);
                tmpSB.append(" ");
            }

            sb.insert(0, tmpSB.toString());

            num /= 1000;
            divCount++;
        }
        return sb.toString().trim();
    }

    private String numToWords(int num) {
        int hundred = num / 100;
        StringBuffer sb = new StringBuffer();
        if(hundred > 0) {
            sb.append(numArr[0][hundred]);
            sb.append(" Hundred");
            num -= hundred * 100;
        }
        int off = num / 10;
        if(num < 20) {
            sb.append(" ");
            sb.append(numArr[off][num - off * 10]);
        } else {
            if(off > 1) {
                sb.append(" ");
                sb.append(numArr[2][off]);    
            }

            sb.append(" ");
            sb.append(numArr[0][num - off * 10]);
        }
        return sb.toString().trim();
    }
}
