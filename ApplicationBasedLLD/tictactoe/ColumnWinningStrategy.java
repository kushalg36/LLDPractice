package tictactoe;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, char mark) {
        for (int col = 0; col < 3; col++) {
            if (board.getMark(0, col) == mark && board.getMark(1, col) == mark && board.getMark(2, col) == mark) {
                return true;
            }
        }
        return false;
    }
    
}
