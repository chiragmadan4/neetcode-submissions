class Solution {
    public int trap(int[] arr) {
        if (arr.length <= 2) {
            return 0;
        }
        int n = arr.length;
        int rmax[] = new int[n];
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = max;
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        max = arr[0];
        for (int i = 1; i < n - 1; i++) {
            int l = max;
            int r = rmax[i];

            if (Math.min(l, r) > arr[i]) {
                ans += Math.min(l, r) - arr[i];
            }
            max = Math.max(max, arr[i]);
        }
        return ans;
    }
}
