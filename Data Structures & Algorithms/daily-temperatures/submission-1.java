class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] arr) {
        if (arr.length == 1) {
            return new int[1];
        }
        Stack<Pair> stack = new Stack<>();
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                stack.push(new Pair(arr[i], i));
                continue;
            }
            Pair top = stack.peek();
            if (arr[i] <= top.val) {
                stack.push(new Pair(arr[i], i));
                continue;
            }
            while (!stack.isEmpty() && arr[i] > top.val) {
                stack.pop();
                ans[top.idx] = i - top.idx;
                if (stack.size() > 0) {
                    top = stack.peek();
                }
            }
            stack.push(new Pair(arr[i], i));
        }
        return ans;
    }
}
