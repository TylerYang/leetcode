public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rList = new ArrayList<String>();
        if(words.length == 0) return rList;
        for(int i = 0; i < words.length; ) {
            int j = i + 1, len = words[i].length();
            while(j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += words[j++].length() + 1;
            }
            rList.add(getJustifyString(words, i, j, maxWidth, len - j + i + 1));
            i = j;
        }
        return rList;
    }
    private String getJustifyString(String[] words, int s, int e, int max, int len) {
        if(e - s == 1 || e == words.length) {
            return getLeftJustifyString(words, s, e, max);
        } else {
            return getCommonJustifyString(words, s, e, max, len);
        }
    }
    private String getLeftJustifyString(String[] words, int s, int e, int max) {
        char[] cArr = new char[max];
        int i = s, j = 0;
        for(int k = 0; k < cArr.length; k++) {
            if(i < e) {
                if(j == words[i].length()) {
                    i++;
                    j = 0;
                    if(i < e) {
                        cArr[k++] = ' '; 
                    }
                }
                if(k == cArr.length) break;
                if(i == e) {
                    cArr[k] = ' ';
                } else {
                    cArr[k] = words[i].charAt(j++);
                }
            } else {
                cArr[k] = ' ';
            }
        }
        return new String(cArr);
    }
    private String getCommonJustifyString(String[] words, int s, int e, int max, int len) {
        char[] cArr = new char[max];
        int totalSpace = max - len, n = e - s - 1;
        int k = 0;
        for(int i = s; i < e; i++) {
            String str = words[i];
            for(int j = 0; j < str.length(); j++) {
                cArr[k++] = str.charAt(j);  
            }
            if(i != e - 1) {
                int space = n == 1 ? totalSpace : totalSpace / n;
                if(totalSpace % n > 0 && n != 1) {
                    space++;
                }
                n--;
                totalSpace -= space;
                for(int m = 0; m < space; m++) {
                    cArr[k++] = ' ';
                }
            }
        }
        return new String(cArr);
    }
}