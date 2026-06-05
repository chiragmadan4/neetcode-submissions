class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        if (arr[0] < arr[n - 1]) {
            return arr[0];
        }
        int ans = arr[0];

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = Math.min(ans, arr[mid]);
            }
        }
        return ans;
    }
}
