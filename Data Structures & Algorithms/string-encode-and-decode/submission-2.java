class Solution {

    public String encode(List<String> strs) {
        int len = 0;
        for (String str: strs) {
            len += str.length();
        }
        String ans = len + "|";
        for (String str: strs) {
            ans += str.length() + "|";
        }
        for (String str: strs) {
            ans += str;
        }
        return ans;
    }

    public List<String> decode(String str) {
        String first = str.split("\\|")[0];
        int actualLen = Integer.parseInt(first);
        String actual = str.substring(str.length()-actualLen, str.length());
        String code = str.substring(0, str.length() - actualLen);

        List<String> ans = new ArrayList<>();
        String lens[] = code.split("\\|");
        int i = 0;
        for (int j = 1; j < lens.length; j++) {
            String len = lens[j];
            int l = Integer.parseInt(len);
            ans.add(actual.substring(i, i + l));
            i = i + l;
        }
        return ans;
    }
}
