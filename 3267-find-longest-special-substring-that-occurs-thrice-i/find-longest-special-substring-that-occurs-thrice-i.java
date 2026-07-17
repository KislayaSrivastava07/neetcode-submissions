class Solution {
    public int maximumLength(String s) {
        List<Integer>[] runs = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            runs[i] = new ArrayList<>();
        }
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            runs[s.charAt(i) - 'a'].add(j - i);
            i = j;
        }
        int left = 1, right = n;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(runs, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(List<Integer>[] runs, int len) {
        for (int c = 0; c < 26; c++) {
            int count = 0;
            for (int run : runs[c]) {
                if (run >= len) {
                    count += run - len + 1;
                }
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }
}
    
