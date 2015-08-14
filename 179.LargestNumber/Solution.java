public class Solution {
    public String largestNumber(int[] nums) {
		String[] strNums = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			strNums[i] = Integer.toString(nums[i]);
		}
        Arrays.sort(strNums, new Comparator<String>(){ 
            public int compare(String m, String n) {
                String str1 = m + n, str2 = n + m;
                return str2.compareTo(str1);
            } 
        });
        if(strNums[0].equals("0")) return "0";
        
        StringBuffer sBuff = new StringBuffer();
        for(int i = 0; i < strNums.length; i++) {
            sBuff.append(strNums[i]);
        }
        return sBuff.toString();
    }
}