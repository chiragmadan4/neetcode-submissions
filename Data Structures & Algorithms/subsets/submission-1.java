class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        fetch(nums, 0, new ArrayList<>());
        return ans;
    }

    public void fetch(int arr[], int idx, List<Integer> branch) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(branch));
            return;
        }
        branch.add(arr[idx]);
        fetch(arr, idx + 1, branch);
        branch.remove(branch.size() - 1);
        fetch(arr, idx + 1, branch);
    }
}
