class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return (long) n * (n + 1) / 2;
        }
        long ans = i + 2;
        for (int j = n - 1; j >= 0; j--) {
            if (j < n - 1 && nums[j] >= nums[j + 1]) {
                break; 
            }
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
            }
            ans += i + 2;
        }
        return ans;
    }
}