class Pair {
    int t;
    String val;
    public Pair(int t, String val) {
        this.t = t;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Pair " + t + " " + val;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        int r = list.size() - 1;
        int l = 0;
        String ans = "";
        int maxTime = -1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid).t <= timestamp) {
                if (list.get(mid).t > maxTime) {
                    ans = list.get(mid).val;
                    maxTime = list.get(mid).t;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
