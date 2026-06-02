class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char arr[] = s1.toCharArray();
        Arrays.sort(arr);
        String s1s = new String(arr);
        int k = s1s.length();
        int n = s2.length();
        for (int i = 0; i < n - k + 1; i++) {
            int l = i;
            int r = i + k;
            String sub = s2.substring(l, r);
            char arr1[] = sub.toCharArray();
            Arrays.sort(arr1);
            String s2s = new String(arr1);
            if (s2s.equals(s1s)) {
                return true;
            }
        }
        return false;
        
    }
}
