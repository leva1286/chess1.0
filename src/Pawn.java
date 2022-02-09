public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0)
            return false;
        if (color.equals("White") && line == 1) {
            if (toLine - line == 2 || toLine - line == 1 && toColumn - column == 0) {
                if (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + 1][column] == null) {
                    return true;
                }
            }
        } else if (color.equals("Black") && line == 6) {
            if (toLine - line == -2 || toLine - line == -1 && toColumn - column == 0) {
                if (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line - 1][column] == null) {
                    return true;
                }
            }
        }
        if (Math.abs(toLine - line) == 1 && toColumn - column == 0) {
            if (chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
        }
        if (color.equals("White")) {
            if (chessBoard.board[line + 1][column - 1] != null && chessBoard.board[line + 1][column - 1].getColor().equals("Black")) {
                if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1) {
                    return true;
                }
            }
            if (chessBoard.board[line + 1][column + 1] != null && chessBoard.board[line + 1][column + 1].getColor().equals("Black")) {
                if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1) {
                    return true;
                }
            }
        } else if (color.equals("Black")) {
            if (chessBoard.board[line - 1][column - 1] != null && chessBoard.board[line - 1][column - 1].getColor().equals("White")) {
                if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1) {
                    return true;
                }
            }
            if (chessBoard.board[line - 1][column + 1] != null && chessBoard.board[line - 1][column + 1].getColor().equals("White")) {
                if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
