class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        int maxM = (int) (Math.log(num) / Math.log(2));
        for (int m = maxM; m >= 1; m--) {
            long left = 2;
            long right = (long) Math.pow(num, 1.0 / m);
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = 1;
                long curr = 1;
                for (int i = 1; i <= m; i++) {
                    if (curr > num / mid) {
                        sum = num + 1;
                        break;
                    }
                    curr *= mid;
                    if (sum > num - curr) {
                        sum = num + 1;
                        break;
                    }
                    sum += curr;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}