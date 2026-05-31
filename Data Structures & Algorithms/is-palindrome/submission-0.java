class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            int front = (int) s.charAt(i);
            while (!isValid(front)) {
                if (i == j) {
                    return true;
                }
                i++;
                front = (int) s.charAt(i);
            }

            int end = (int) s.charAt(j);
            while (!isValid(end)) {
                if (i == j) {
                    return true;
                }
                j--;
                end = (int) s.charAt(j);
            }
            if (front >= 97) {
                front-=32;
            }
            if (end >= 97) {
                end-=32;
            }
            if (front != end) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }

    public boolean isValid(int c) {
        if (c >= (int) '0' && c <= (int) '9') {
            return true;
        }
        if (c >= (int) 'A' && c <= (int) 'Z') {
            return true;
        }
        if (c >= (int) 'a' && c <= (int) 'z') {
            return true;
        }
        return false;
    }
}
