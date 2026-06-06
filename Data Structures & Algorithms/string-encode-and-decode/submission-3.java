class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str); 
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        int i = 0;
        for (int j = 1; j < str.length(); j++) {
            if (str.charAt(j) != '#') {
                continue;
            }
            String lenStr = str.substring(i, j);
            int len = Integer.parseInt(lenStr);
            ans.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
            j = j + 1 + len;
        }
        return ans;
    }
}
