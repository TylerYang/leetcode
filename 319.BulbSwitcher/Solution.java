public class Solution {
  public int bulbSwitch(int n) {
    int count = 0, i = 1;
    while(i * i <= n) {
      count++;
      i++;
    }
    return count;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    int n = 0;
    System.out.println(sol.bulbSwitch(n));
  }
}
