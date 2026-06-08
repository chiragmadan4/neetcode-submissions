class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        fetch(nums, 0, 0, target, new ArrayList<>());
        return ans;
    }

    public void fetch(int arr[], int idx, int curr, int target, List<Integer> branch) {
        if (curr == target) {
            ans.add(new ArrayList<>(branch));
            return;
        }
        if (idx >= arr.length || curr > target) {
            return;
        }
        
        branch.add(arr[idx]);
        fetch(arr, idx, curr + arr[idx], target, branch);
        branch.remove(branch.size() - 1);
        fetch(arr, idx + 1, curr, target, branch);
    }
}
