import java.util.TreeMap;
public class Solution2 {
  public int countRangeSum(int[] nums, int lower, int upper) {
   int n = nums.length;
   long sums[] = new long[n];
   TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
   for(int i = 0; i < n; i++) {
     if(i == 0) {
       sums[i] = nums[i];
     } else {
       sums[i] = sums[i - 1] + nums[i];
     }
     map.put(sums[i], 0);
   }
   map.put(Long.MAX_VALUE, 0);
   map.put(Long.MIN_VALUE, 0);

   int tot = 1;
   for(Long key: map.keySet()) {
     map.put(key, tot++);
   }

   SegmentTree st = new SegmentTree(n + 2);
   st.query(1, 2, 1);
   int ans = 0;

   long right, left;
   for(int i = 0; i < n; i++) {
     long s = nums[i];
     left = map.ceilingKey(s - upper);
     right = map.floorKey(s - lower);

     if(right >= left) {
       ans += st.query(map.get(left), map.get(right), 1);
       if(lower <= s && s <= upper) {
         ans++;
       }
       st.update(map.get(s), 1, 1);
     }
   }
   return ans;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {-2, 5, -1};
    int lower = -2, upper = 2;
    System.out.println(sol.countRangeSum(nums, lower, upper));
  }
}
class SegmentTree {
  int[] lazy;
  int n;
  node[] nodes;

  SegmentTree(int n) {
    this.n = n;
    lazy = new int[n + 1];
    nodes = new node[n * 5];
    build(1, n, 1);
  }
  public int build(int left, int right, int idx) {
    nodes[idx] = new node();
    nodes[idx].left = left;
    nodes[idx].right = right;
    if(left == right) return nodes[idx].lazy = lazy[left];
    int mid = (left + right) >> 1;
    return nodes[idx].lazy = build(left, mid, idx << 1) + build(mid + 1, right, idx << 1 | 1);
  }
  public void update(int key, int x, int idx) {
    nodes[idx].lazy += x;
    if(nodes[idx].left == nodes[idx].right) return;
    int mid = nodes[idx].calmid();
    if(key <= mid) {
      update(key, x, idx << 1);
    } else {
      update(key, x, idx << 1 | 1);
    }
  }

  public int query(int left, int right, int idx) {
    if(left == nodes[idx].left && right == nodes[idx].right)
      return nodes[idx].lazy;
    int mid = nodes[idx].calmid();

    if(mid >= right) return query(left, right, idx << 1);
    if(mid + 1 <= left) return query(left, right, idx << 1 | 1);
    return query(left, mid, idx << 1) + query(mid + 1, right, idx << 1 | 1);
  }
  class node {
    int left, right, lazy;

    int calmid() {
      return (left + right) >> 1;
    }
  }
}
