class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("/") && !str.equals("*")) {
                stack.push(Integer.parseInt(str));
                continue;
            }
            int second = stack.pop();
            int first = stack.pop();

            if (str.equals("+")) {
                stack.push(first + second);
            }
            if (str.equals("-")) {
                stack.push(first - second);
            }
            if (str.equals("*")) {
                stack.push(first * second);
            }
            if (str.equals("/")) {
                stack.push(first / second);
            }
        }
        return stack.pop();
    }
}
