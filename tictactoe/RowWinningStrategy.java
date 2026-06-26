package tictactoe;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, char mark) {
        for (int row = 0; row < 3; row++) {
            if (board.getMark(row, 0) == mark && board.getMark(row, 1) == mark && board.getMark(row, 2) == mark) {
                return true;
            }
        }
        return false;
    }
}
