public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) return -1;
        if(gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
        int resGas = 0, i = 0, j = 0, count = 0;
        while(i < gas.length) {
            if(gas[i] - cost[i] >= 0) {
                break;
            }
            i++;
        }
        if(i == gas.length) return -1;
    
        int most = gas.length * 2 - 1;
        while(count < gas.length && j < most) {
            int nextI = (i + gas.length) % gas.length;
            int initResGas = resGas;
            resGas = resGas + gas[nextI] - cost[nextI];
            if(resGas < 0) {
                resGas = 0;
                count = 0;
                if(initResGas == 0) i++;
            } else {
                count++;
                i++;
            }
            j++;
        }
        
        return count == gas.length ? (i + gas.length) % gas.length : -1;
    }
}