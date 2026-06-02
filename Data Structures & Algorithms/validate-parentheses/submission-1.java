class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char top = stack.peek();
                if (getOpp(top) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
        
    }
    public char getOpp(char c) {
        if (c == '(') {
            return ')';
        }
        if (c == '{') {
            return '}';
        }
        if (c == '[') {
            return ']';
        }
        return 'a';
    }
}
