class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return fetch(nums, 0);
    }

    public List<List<Integer>> fetch(int arr[], int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        if (idx == arr.length - 1) {
            ans.add(new ArrayList<>());
            ans.add(Arrays.asList(arr[idx]));
            return ans;
        }

        List<List<Integer>> subAns = fetch(arr, idx + 1);
        ans.addAll(subAns);
        for (List<Integer> sub: subAns) {
            List<Integer> m = new ArrayList<>(sub.size() + 1);
            m.add(arr[idx]);
            m.addAll(sub);
            ans.add(m);
        }
        return ans;
    }
}
