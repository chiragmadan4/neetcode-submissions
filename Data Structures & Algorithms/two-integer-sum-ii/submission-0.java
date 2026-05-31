class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}
