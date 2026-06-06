class Pair {
    int pos;
    int speed;
    float time;
    public Pair(int pos, int speed, float time) {
        this.pos = pos;
        this.speed = speed;
        this.time = time;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if (n == 1) {
            return 1;
        }
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(position[i], speed[i], (float) (target - position[i]) / speed[i]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.pos, b.pos));

        int ans = 0;
        int i = n - 1;
        while (i >= 0) {
            int j = i;
            while (j > 0 && arr[j - 1].time <= arr[i].time) {
                j--;
            }
            i = j - 1;
            ans++;
        }
        return ans;
    }
}
