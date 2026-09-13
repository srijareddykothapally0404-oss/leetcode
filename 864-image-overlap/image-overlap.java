class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
         int n = img1.length;

        int[][] count = new int[2 * n - 1][2 * n - 1];

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(img1[i][j] == 1) {

                    for(int x = 0; x < n; x++) {
                        for(int y = 0; y < n; y++) {

                            if(img2[x][y] == 1) {

                                int dx = x - i + n - 1;
                                int dy = y - j + n - 1;

                                count[dx][dy]++;

                                ans = Math.max(ans, count[dx][dy]);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}