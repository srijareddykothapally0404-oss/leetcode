class Solution {
    public String lexPalindromicPermutation(String s, String target) {
           int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String best = null;

        for (int change = 0; change < halfLen; change++) {
            int[] cnt = halfFreq.clone();
            StringBuilder first = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < change; i++) {
                int x = target.charAt(i) - 'a';

                if (cnt[x] == 0) {
                    possible = false;
                    break;
                }

                first.append((char) ('a' + x));
                cnt[x]--;
            }

            if (!possible) {
                continue;
            }

            int t = target.charAt(change) - 'a';
            int chosen = -1;

            for (int c = t + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    chosen = c;
                    break;
                }
            }

            if (chosen == -1) {
                continue;
            }

            first.append((char) ('a' + chosen));
            cnt[chosen]--;

            for (int c = 0; c < 26; c++) {
                while (cnt[c] > 0) {
                    first.append((char) ('a' + c));
                    cnt[c]--;
                }
            }

            String candidate = makePalindrome(first.toString(), middle, n);

            if (candidate.compareTo(target) > 0) {
                if (best == null || candidate.compareTo(best) < 0) {
                    best = candidate;
                }
            }
        }

        int[] cnt = halfFreq.clone();
        StringBuilder first = new StringBuilder();
        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] == 0) {
                possible = false;
                break;
            }

            first.append((char) ('a' + x));
            cnt[x]--;
        }

        if (possible) {
            String candidate = makePalindrome(first.toString(), middle, n);

            if (candidate.compareTo(target) > 0) {
                if (best == null || candidate.compareTo(best) < 0) {
                    best = candidate;
                }
            }
        }

        return best == null ? "" : best;
    }

    private String makePalindrome(String first, int middle, int n) {
        StringBuilder ans = new StringBuilder();
        ans.append(first);

        if (n % 2 == 1) {
            ans.append((char) ('a' + middle));
        }

        for (int i = first.length() - 1; i >= 0; i--) {
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}