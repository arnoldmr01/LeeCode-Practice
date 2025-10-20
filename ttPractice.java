class Solution{
    static final long MOD = 1_000_000_007L;

    // 回傳長度為 clipLength 的 smooth 串數量（mod 1e9+7）
    public int FindNumOfSmoothClip(int clipLength, int diff) {
        if (clipLength <= 0) return 0;
        if (diff >= 25) {                      // 相鄰不限
            return (int) modPow(26, clipLength, MOD);
        }
        if (clipLength == 1) return 26;        // 單字母任選

        long[] prev = new long[26];
        java.util.Arrays.fill(prev, 1);        // 長度1：每個字母1種
        long[] curr = new long[26];

        for (int len = 2; len <= clipLength; len++) {
            // 前綴和 ps[i] = prev[0..i-1] 之和
            long[] ps = new long[27];
            for (int i = 0; i < 26; i++) ps[i + 1] = (ps[i] + prev[i]) % MOD;

            for (int c = 0; c < 26; c++) {
                int L = Math.max(0, c - diff);
                int R = Math.min(25, c + diff);
                long val = (ps[R + 1] - ps[L]) % MOD;
                if (val < 0) val += MOD;
                curr[c] = val;
            }
            long[] t = prev; prev = curr; curr = t; // 滾動陣列
        }

        long ans = 0;
        for (int c = 0; c < 26; c++) ans = (ans + prev[c]) % MOD;
        return (int) ans;
    }

    private long modPow(long a, long e, long mod) {
        long r = 1 % mod; a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return r;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int clipLength = 2;
        int diff = 3;
        int result = sol.FindNumOfSmoothClip(clipLength, diff);
        System.out.println(result); // 170
    }
}