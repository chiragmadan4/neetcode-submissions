class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int power = 31;
        for (int i = 0; i < 32; i++) {
            int m = n & 1;
            if (m > 0) {
                ans += 1 << power;
            }
            n = n >> 1;
            power--;
        }
        return ans;
    }
}
