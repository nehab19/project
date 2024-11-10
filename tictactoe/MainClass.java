package guru.springframework.spring5webapp.designpattern.project.tictactoe;

public class MainClass {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame=new TicTacToeGame();
        ticTacToeGame.initialiseGame();
        String winnerStatus= ticTacToeGame.startGame();
        if("tie".equalsIgnoreCase(winnerStatus)){
            System.out.println("Oops! The game is a tie!");
        }else{
            System.out.println("And the winner is : " +winnerStatus);
        }
    }
}
