class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n;
        int[] length = new int[n + 2];
        int countM = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            int left = length[pos - 1];
            int right = length[pos + 1];
            int newLen = left + right + 1;
            if (left == m){countM--;} 
            if (right == m) {countM--;}
            length[pos - left] = newLen;
            length[pos + right] = newLen;
            if (newLen == m) {countM++;}
            if (countM > 0) {
                ans = i + 1; 
            }
        }
        return ans;
    }
}