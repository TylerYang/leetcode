public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int pA, pB, pC, pD;
        pA = Math.max(A, E);
        pB = Math.max(B, F);
        pC = Math.min(G, C);
        pD = Math.min(D, H);

        int covered = 0;
        if(pC > pA && pD > pB){
            covered = (pC - pA) * (pD - pB);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - covered;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = -1;
        int F = -1;
        int G = 1;
        int H = 1;

        System.out.println(sol.computeArea(A, B, C, D, E, F, G, H));
    }
}
