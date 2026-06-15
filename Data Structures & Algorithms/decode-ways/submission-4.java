class Solution {
    public int numDecodings(String s) {
        return fetch(s);
    }

    public int fetch(String s) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int ans[] = new int[n + 1];
        ans[n] = 1;
        if (s.charAt(n - 1) != '0') {
            ans[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int a = ans[i + 1];
            String t = s.charAt(i) + "" + s.charAt(i + 1);
            if (isValid(t)) {
                a += ans[i + 2];
            }
            ans[i] = a;
        }
        return ans[0];
    }

    public boolean isValid(String s) {
        int i = Integer.parseInt(s);
        return i <= 26;
    }
}
