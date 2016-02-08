public class FenwickTree {
  private int len;
  private int[] arr;
  public FenwickTree(int len) {
    this.len = len;
    this.arr = new int[len + 1];
  }
  public void insert(int x, int num) {
    while(x <= len) {
      arr[x] += num;
      x += lowbit(x);
    }
  }
  public int lowbit(int x) {
    return x & -x;
  }
  public int sum(int x) {
    int s = 0;
    while(x > 0) {
      s += arr[x];
      x -= lowbit(x);
    }
    return s;
  }
}
