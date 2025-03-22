

public class sudokuSolver {
  
    public static void solveSoduko(char[][] board) {
       solve(board);

    }

    private static boolean solve(char[][] board) {
        for ( int row = 0; row < 9; row++) {
            for (int col = 0; col < 9 ; col++) {
                if (board[row][col] == '.') {  //Find empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if ( isValid(board, row, col, num)) {
                            board[row][col] = num; // place number

                            if (solve(board)) {  //Recur to solve next cell
                                return true;
                            }

                            board[row][col] = '.'; //Backtrack if not valid
                        }
                    }
                   
                    return false; // if no number works, return false
                }
            }
        }
        return true; // All cells are filled correctly

    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num || board[i][col] == num || board[row / 3 * 3 + i / 3][col / 3 * 3 + 1 % 3] == num) {
                return false; // Check row, check column and 3x3 box

            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main (String args[]){
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            
        };

        System.out.println("Sudoku Puzzle: ");
        printBoard(board);
        solveSoduko(board);
        System.out.println("\nSolved Sudoku: ");
        printBoard(board);
    }

}