class Solution {
    public void gameOfLife(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        // 8 directions
        int[][] dirs = {
            {1,0}, {-1,0}, {0,-1}, {0,1},
            {1,1}, {-1,1}, {1,-1}, {-1,-1}
        };

        // new board to store result
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int live = 0;

                // count live neighbors
                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || x >= n || y < 0 || y >= m) continue;

                    if (board[x][y] == 1) live++;
                }

                // apply rules

                // Rule 1 & 3: live cell dies
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    ans[i][j] = 0;
                }
                // Rule 2: live cell survives
                else if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    ans[i][j] = 1;
                }
                // Rule 4: dead becomes live
                else if (board[i][j] == 0 && live == 3) {
                    ans[i][j] = 1;
                }
                // otherwise stays dead
                else {
                    ans[i][j] = 0;
                }
            }
        }

        // copy result back
        for (int i = 0; i < n; i++) {
            System.arraycopy(ans[i], 0, board[i], 0, m); ///System.arraycopy(source, srcPos, dest, destPos, length);
        }
    }
}