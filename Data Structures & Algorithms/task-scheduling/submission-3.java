class Pair {
    char task;
    int n;
    int last;
    Pair(char task, int n, int last) {
        this.task = task;
        this.n = n;
        this.last = last;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair p) -> p.n).reversed()
        );
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: map.keySet()) {
            Pair p = new Pair(c, map.get(c), -1);
            pq.add(p);
        }
        int t = 1;
        while (!pq.isEmpty()) {
            List<Pair> addBack = new ArrayList<>();
            Pair selected = null;
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (p.last == -1 || t - p.last > n) {
                    selected = p;
                    break;
                }
                addBack.add(p);
            }
            if (selected != null) {
                selected.n = selected.n - 1;
                selected.last = t;
                if (selected.n > 0) {
                    addBack.add(selected);
                }
            }
            for (Pair p: addBack) {
                pq.add(p);
            }
            if (pq.isEmpty()) {
                break;
            }
            t++;
        }
        return t;
    }
}
