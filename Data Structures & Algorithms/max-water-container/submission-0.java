class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int n = heights.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            max = Math.max(area, max);

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
        
    }
}
