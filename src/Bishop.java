public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn > 7 || toLine > 7 || toColumn < 0 || toLine < 0)
            return false;
        if (line == toLine && column == toColumn)
            return false;
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                if (toLine - line > 0 && toColumn - column > 0) {
                    for (int i = toLine - line - 1; i > 0; i--) {
                        if (chessBoard.board[i][i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else if (toLine - line < 0 && toColumn - column < 0) {
                    for (int i = Math.abs(toLine - line) - 1; i > 0; i--) {
                        if (chessBoard.board[toLine + i][toColumn + i] != null) {
                            return false;
                        }
                    }
                    return true;
                } else if (toLine - line < 0 && toColumn - column > 0) {
                    for (int i = Math.abs(toLine - line) - 1; i > 0; i--) {
                        if (chessBoard.board[toLine + i][toColumn - i] != null) {
                            return false;
                        }
                    }
                    return true;

                } else if (toLine - line > 0 && toColumn - column < 0) {
                    for (int i = Math.abs(toLine - line) - 1; i > 0; i--) {
                        if (chessBoard.board[toLine - i][toColumn + i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
