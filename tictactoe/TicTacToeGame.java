package guru.springframework.spring5webapp.designpattern.project.tictactoe;

import guru.springframework.spring5webapp.designpattern.project.tictactoe.model.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    //adding players to the game and assigning the board of relevant size
    public void initialiseGame() {
        players = new LinkedList<>();
        PlayingPieceX playingPieceX = new PlayingPieceX();
        System.out.println("Enter the name of player 1 : ");
        String inputName1 = new Scanner(System.in).nextLine();
        Player player1 = new Player(inputName1, playingPieceX);

        System.out.println("Enter the name of player 2 : ");
        String inputName2 = new Scanner(System.in).nextLine();
        PlayingPieceO playingPieceO = new PlayingPieceO();
        Player player2 = new Player(inputName2, playingPieceO);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    //now let's start the game
    public String startGame() {

        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();

            //print the board to let user know where he/she can place
            gameBoard.printBoard();

            //get the free spaces
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();

            //if there are spaces then there is no winner as of now
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //if not tie then get the user's input
            System.out.println("Player :  " + playerTurn.name + " Enter the row and column : ");
            Scanner inputValues = new Scanner(System.in);
            String input = inputValues.nextLine();
            String[] values = input.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);
            System.out.println("Piece" + playerTurn.playingPiece.pieceType);

            //as we get the user input we will place the piece where user wants
            boolean pieceAdd = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if (!pieceAdd) {
                //if the row and column is already filled then the user has entered the incorrect position
                System.out.println("Incorrect position chosen, Please try again with another position");
                //now the user has entered the wrong position he/she will enter the piece again
                players.addFirst(playerTurn);
                continue;
            }
            // if player added the piece successfully then we will push him at last so that another user can get the chance now.
            players.addLast(playerTurn);

            boolean isThereWinner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if (isThereWinner) {
                return playerTurn.name;
            }
        }
        return "tie";
    }

    private boolean isThereWinner(int inputRow, int inputColumn, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //first lets check if there is match in row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[inputRow][i] == null || gameBoard.board[inputRow][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        // let's check for column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][inputColumn] == null || gameBoard.board[i][inputColumn].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonal
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }
        //need to check antidiagonal
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
