class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                String substring = s.substring(i, j);
                if (check(substring) && substring.length() > ans.length()) {
                    ans = substring;
                }
            }
        }
        return ans;
    }
    public boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
