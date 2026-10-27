class Solution {
    public String[] createGrid(int m, int n) {
         String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder s = new StringBuilder();

            for (int j = 0; j < n; j++) {
                s.append('#');
            }

            grid[i] = s.toString();
        }

        char[] first = new char[n];
        for (int j = 0; j < n; j++) {
            first[j] = '.';
        }
        grid[0] = new String(first);

        for (int i = 1; i < m; i++) {
            char[] row = grid[i].toCharArray();
            row[n - 1] = '.';
            grid[i] = new String(row);
        }

        return grid;
    }
}