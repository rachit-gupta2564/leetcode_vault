// Last updated: 22/09/2025, 16:17:38
class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i-1][j] == 'X') continue;
                    if (j > 0 && board[i][j-1] == 'X') continue;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
