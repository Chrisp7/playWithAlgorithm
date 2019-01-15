package Tree;

public class Lc79 {
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    private boolean wordSearch(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }

        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (withinBoard(newx, newy) && !visited[newx][newy]) {
                    if (wordSearch(board, word, index + 1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean withinBoard(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearch(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
}
