import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* Type your code here. */
        Board board = new Board();
        board.print();

        //While board isn't full, or while nobody has won, will be main part of code
        while(!board.isFull()||!board.isWin()) {
            System.out.println(board.getCurrentPlayer()+"player: Enter row and column numbers:");
            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1;
            //Case for if the row or col is out of bounds
            while(row<0 || row>2 || col<0 || col>2){
                System.out.println("Incorrect cell. Try again!");
                System.out.println(board.getCurrentPlayer()+"player: Enter row and column numbers:");
                row = input.nextInt() - 1;
                col = input.nextInt() - 1;
            }
            board.setRowCol(row,col);
            board.print();
            board.changePlayer();
        }
        //Case for if board is won
        board.getWinner();

        //Case for if board is fll, but nobody won
        if(board.isFull() && !board.isWin()) {
        System.out.println("A draw!");
        }
        System.out.println("Goodbye!");
        }
    }


