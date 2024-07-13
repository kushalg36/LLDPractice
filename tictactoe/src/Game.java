import Model.Board;
import Model.Player;
import Model.PlayingPieceO;
import Model.PlayingPieceX;
import com.sun.tools.javac.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board gameBoard;

    public void init() {
        players = new LinkedList<>();
        PlayingPieceX xPiece = new PlayingPieceX();
        Player player1 = new Player("player1", xPiece);
        PlayingPieceO oPiece = new PlayingPieceO();
        Player player2 = new Player("player2", oPiece);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + playerTurn.name + "Enter row, col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            // complete the implementation of isWinner by nQueen
//            boolean winner =  isWinner(inputRow, inputCol, playerTurn.playingPiece.pieceType);
//            if(winner) return playerTurn.name;;
        }
        return "tie";
    }
}
