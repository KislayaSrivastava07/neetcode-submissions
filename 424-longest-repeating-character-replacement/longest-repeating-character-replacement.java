class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq= new int[26];
        int maxFreq=0;
        int left =0; 
        int ans=0;
        for (int right =0; right<s.length();right++){
            char x= s.charAt(right);
            int id= x-'A';
            freq[id]= freq[id]+1;
            maxFreq= Math.max(maxFreq, freq[id]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
              ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}