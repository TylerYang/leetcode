public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length <= 1) return ratings.length;
        int minCandy = 1, prevCandy = 1, peekPos = 0, peekCandy = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                minCandy += ++prevCandy;
                peekPos = i;
                peekCandy = prevCandy;
            } else {
                if(ratings[i] == ratings[i - 1]) {
                    peekCandy = 1;
                    peekPos = i;
                }
                prevCandy = 1;
                minCandy += prevCandy;
                
                //1 2 4 2 1 means the peek element 4(candy is 3) won't smaller than 2's candy (no need to minCandy--)
                //1 2 4 3 2 1 will need minCandy--
                if(i != peekPos && peekCandy > i - peekPos) {
                    minCandy--;
                }
                minCandy += i - peekPos;
            }
        }
        return minCandy;
    }
}