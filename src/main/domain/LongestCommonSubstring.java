package main.domain;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String typo = "hish";
        String[] suggestion = new String[]{"fish", "hush"};
        String solve = new LongestCommonSubstring().solve(typo, suggestion);
        System.out.println(solve);
    }

    public String solve(String typo, String[] suggestions) {
        String bestWord = "";
        int highestScore = 0;
        for (String word : suggestions) {
            int score = solve(typo, word);
            if (score > highestScore) {
                bestWord = word;
                highestScore = score;

            }
        }

        return bestWord;
    }

    protected int solve(String typo, String word) {
        int[][] grid = new int[typo.length()][word.length()];

        for (int i = 0; i < typo.length(); i++) {
            char rowChar = typo.charAt(i);
            for (int k = 0; k < word.length(); k++) {
                char colChar = word.charAt(k);

                if (rowChar == colChar) {
                    updateGridForLetterMatch(grid, i, k);
                } else {
                    updateGridForNonMatch(grid, i, k);
                }
            }
        }

        return grid[typo.length() - 1][word.length() - 1];

    }

    // if no previous take 1, otherwise add to previous match
    private void updateGridForLetterMatch(int[][] grid, int row, int col) {
        if (row == 0 || col == 0) {
            grid[row][col] = 1;
        } else {
            grid[row][col] = grid[row - 1][col - 1] + 1;
        }
    }

    // take max of previous left or top element
// if first element , =
    private void updateGridForNonMatch(int[][] grid, int row, int col) {

        if (row == 0 && col == 0) {
            grid[row][col] = 0;
        } else if (row == 0) {
            grid[row][col] = grid[row][col - 1];
        } else if (col == 0) {
            grid[row][col] = grid[row - 1][col];
        } else {
            grid[row][col] = Math.max(grid[row][col - 1], grid[row - 1][col]);
        }


    }


}
