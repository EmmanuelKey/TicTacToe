public class Board {

    private char[][] board;
    private char currentPlayer;
    private char playerWon;
    /**
     * This is the constructor for the class. It initializes the board so all cells in the board are equal to '-'. The currentPlayer
     * is initialized to 'x'.
     *
     */
    public Board() {
        /*
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            board[i][j] = '-';
         }
      }
      */
        char board[][] =
                { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        currentPlayer  = 'x';
        playerWon = 'e';
    }

    /**
     * The method outputs the board in the following format. First the message "Current board" underligned is printed.
     * Then the content of the board is printed as a 3 by 3 matrix.
     */
    public void print() {
        System.out.println("Current Board");
        System.out.println("-------------");

        for (int i = 0; i <3; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < 3; j++) { //this equals to the column in each row.
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

    }
    public char getCurrentPlayer(){
        return currentPlayer;
    }
    /**
     * The method checks if all the positions on the board have been played.
     *
     * @return true if all the cells in the board are different than '-', false otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i]=='-'){
                    return false;
                }
                else{
                    continue;
                }

            }
        }
        return true;
    }

    /**
     * The method checks if there is a winner.
     *
     * @return true if either a column, a row or a diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
    public boolean isWin() {
        if(checkRows() || checkColumns() || checkDiagonals()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * The method prints out the Player that won the game, in the form of printing it to the console.
     *
     */
    public void getWinner(){
        if(isWin()) {
            System.out.println(playerWon + "player wins !");
        }
        }



    /**
     * The method checks if at least one row is occupied by the same player.
     *
     * @return true if any row is filled by the same character and the character is different than '-',
     * false otherwise.
     */
    private boolean checkRows() {
        for (int i = 0; i < board.length; i++) {
            if(board[i][i] != '-' && board[i][i] == board[i][i+1] && board[i][i] == board[i][i+2]){
                playerWon = board[i][i];
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    /**
     * The method checks if at least one column is occupied by the same player.
     *
     * @return true if any column is filled by the same character and the character is different than '-',
     * false otherwise.
     */
    private boolean checkColumns() {
        for (int i = 0; i < board.length; i++) {
            if(board[i][i] != '-' && board[i][i] == board[i+1][i] && board[i][i] == board[i+2][i]){
                playerWon = board[i][i];
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * The method checks if at least one diagonal is occupied by the same player.
     *
     * @return true if any diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
    private boolean checkDiagonals() {
        if(board[0][0] != '-' &&board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            playerWon = board[0][0];
            return true;
        }
        else if(board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            playerWon = board[0][2];
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * The method changes the currentPlayer. If the currentPlayer is 'x', it changes to 'o'.
     * If the currentPlayer is 'o', it changes to 'x'.
     *
     */
    public void changePlayer() {
        if(currentPlayer == 'x'){
            currentPlayer = 'o';
        }
        else{
            currentPlayer = 'x';
        }
    }

    /**
     * The method attempts to set the cell on the position indicated by the row and column given to the currentPlayer value if
     * the cell is unoccupied (equal to '-') in which case returns true. If the position is occupied (not equal to '-') the cell
     * remains unchanged and the method returns false.
     *
     */
    public boolean setRowCol(int row, int col) {
        if(board[row][col] == '-'){
            board[row][col] = currentPlayer;
            return true;
        }
        else{
            return false;
        }
    }

}

