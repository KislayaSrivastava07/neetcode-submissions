class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
          int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }
        set.clear();
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = set.size();
            set.add(nums[i]);
        }
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = prefix[i] - suffix[i];
        }
        return diff;
    }
}