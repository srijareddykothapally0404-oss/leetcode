class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) {
                        open--;
                    } else {
                        ans++;
                    }
                    i += 2;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        ans++;
                    }
                    ans++;
                    i++;
                }
            }
        }

        return ans + 2 * open;

    }
}