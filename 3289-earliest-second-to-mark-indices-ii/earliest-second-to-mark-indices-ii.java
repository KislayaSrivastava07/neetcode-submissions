class Solution {
    private int[] nums;
    private int[] changeIndices;
    private boolean[] first;
    private long sum;

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;

        if (m < n) return -1;

        this.nums = nums;
        this.changeIndices = changeIndices;

        first = new boolean[m];

        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < m; i++) {
            if (nums[changeIndices[i] - 1] > 1 && seen.add(changeIndices[i])) {
                first[i] = true;
            }
        }

        sum = 0;
        for (int x : nums) sum += x;
        sum += n;

        int left = n;
        int right = (int) Math.min(sum, (long) m) + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left > Math.min(sum, (long) m) ? -1 : left;
    }

    private boolean check(int limit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long need = sum;
        int free = 0;

        for (int i = limit - 1; i >= 0 && need > limit; i--) {

            if (!first[i]) {
                free++;
                continue;
            }

            int val = nums[changeIndices[i] - 1];

            pq.offer(val);
            need -= val - 1;

            if (pq.size() > free) {
                need += pq.poll() - 1;
                free++;
            }
        }

        return need <= limit;
    }
}