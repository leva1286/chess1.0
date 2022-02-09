public class King extends ChessPiece {


    public King(String color) {
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
        if ((toLine - line == 0 || toColumn - column == 0) && (Math.abs(toLine - line) == 1 || Math.abs(toColumn - column) == 1)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                if (!isUnderAttack(chessBoard, toLine, toColumn)) {
                    check = false;
                    return true;
                }
            }
        }
        if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) && (Math.abs(toLine - line) == 1)) {
            if (!chessBoard.board[toLine][toColumn].getColor().equals(this.color) || chessBoard.board[toLine][toColumn] == null) {
                if (!isUnderAttack(chessBoard, toLine, toColumn)) {
                    check = false;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {

        for (int i = line + 1; i < 8; i++) {
            if (chessBoard.board[i][column] == null)
                continue;
            if (!chessBoard.board[i][column].getSymbol().equals("H") && !chessBoard.board[i][column].getSymbol().equals("P") && !chessBoard.board[i][column].getSymbol().equals("B") &&
                    !chessBoard.board[i][column].getSymbol().equals("K")) {
                if (!chessBoard.board[i][column].getColor().equals(this.color) && chessBoard.board[i][column].getSymbol().equals("Q") ||
                        !chessBoard.board[i][column].getColor().equals(this.color) && chessBoard.board[i][column].getSymbol().equals("R")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = line - 1; i > -1; i--) {
            if (chessBoard.board[i][column] == null)
                continue;
            if (!chessBoard.board[i][column].getSymbol().equals("H") && !chessBoard.board[i][column].getSymbol().equals("P") && !chessBoard.board[i][column].getSymbol().equals("B") &&
                    !chessBoard.board[i][column].getSymbol().equals("K")) {
                if (!chessBoard.board[i][column].getColor().equals(this.color) && chessBoard.board[i][column].getSymbol().equals("Q") ||
                        !chessBoard.board[i][column].getColor().equals(this.color) && chessBoard.board[i][column].getSymbol().equals("R")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = column - 1; i > -1; i--) {
            if (chessBoard.board[line][i] == null)
                continue;
            if (!chessBoard.board[line][i].getSymbol().equals("H") && !chessBoard.board[line][i].getSymbol().equals("P") && !chessBoard.board[line][i].getSymbol().equals("B") &&
                    !chessBoard.board[line][i].getSymbol().equals("K")) {
                if (!chessBoard.board[line][i].getColor().equals(this.color) && chessBoard.board[line][i].getSymbol().equals("Q") ||
                        !chessBoard.board[line][i].getColor().equals(this.color) && chessBoard.board[line][i].getSymbol().equals("R")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = column + 1; i < 8; i++) {
            if (chessBoard.board[line][i] == null)
                continue;
            if (!chessBoard.board[line][i].getSymbol().equals("H") && !chessBoard.board[line][i].getSymbol().equals("P") && !chessBoard.board[line][i].getSymbol().equals("B") &&
                    !chessBoard.board[line][i].getSymbol().equals("K")) {
                if (!chessBoard.board[line][i].getColor().equals(this.color) && chessBoard.board[line][i].getSymbol().equals("Q") ||
                        !chessBoard.board[line][i].getColor().equals(this.color) && chessBoard.board[line][i].getSymbol().equals("R")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = line - 1; i <= line + 1; i += 2) {
            for (int j = column - 2; j <= column + 2; j += 4) {
                if (i < 0 || i > 7 || j < 0 || j > 7)
                    continue;
                if (chessBoard.board[i][j] == null)
                    continue;
                if (chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getColor().equals(this.color)) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            }
        }
        for (int i = line - 2; i <= line + 2; i += 4) {
            for (int j = column - 1; j <= column + 1; j += 2) {
                if (i < 0 || i > 7 || j < 0 || j > 7)
                    continue;
                if (chessBoard.board[i][j] == null)
                    continue;
                if (chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getColor().equals(this.color)) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            }
        }
        for (int i = column - 1, j = line + 1; i < column + 2; i += 2) {
            if (i < 0 || i > 7 || j < 0 || j > 7)
                continue;
            if (chessBoard.board[j][i] == null)
                continue;
            if (chessBoard.board[j][i].getSymbol().equals("P") && this.color.equals("White") && chessBoard.board[j][i].color.equals("Black")) {
                System.out.println("вам будет поставлен шах поэтому");
                return true;
            } else break;
        }
        for (int i = column - 1, j = line - 1; i < column + 2; i += 2) {
            if (i < 0 || i > 7 || j < 0 || j > 7)
                continue;
            if (chessBoard.board[j][i] == null)
                continue;
            if (chessBoard.board[j][i].getSymbol().equals("P") && this.color.equals("Black") && chessBoard.board[j][i].color.equals("White")) {
                System.out.println("вам будет поставлен шах поэтому");
                return true;
            } else break;
        }
        for (int i = line + 1, j = column + 1; i < 8 && j < 8; i++, j++) {
            if (chessBoard.board[i][j] == null)
                continue;
            if (!chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getSymbol().equals("P") && !chessBoard.board[i][j].getSymbol().equals("R") &&
                    !chessBoard.board[i][j].getSymbol().equals("K")) {
                if (!chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("Q") ||
                        !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("B")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = line - 1, j = column + 1; i >= 0 && j < 8; i--, j++) {
            if (chessBoard.board[i][j] == null)
                continue;
            if (!chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getSymbol().equals("P") && !chessBoard.board[i][j].getSymbol().equals("R") &&
                    !chessBoard.board[i][j].getSymbol().equals("K")) {
                if (!chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("Q") ||
                        !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("B")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = line + 1, j = column - 1; i < 8 && j >= 0; i++, j--) {
            if (chessBoard.board[i][j] == null)
                continue;
            if (!chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getSymbol().equals("P") && !chessBoard.board[i][j].getSymbol().equals("R") &&
                    !chessBoard.board[i][j].getSymbol().equals("K")) {
                if (!chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("Q") ||
                        !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("B")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        for (int i = line - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard.board[i][j] == null)
                continue;
            if (!chessBoard.board[i][j].getSymbol().equals("H") && !chessBoard.board[i][j].getSymbol().equals("P") && !chessBoard.board[i][j].getSymbol().equals("R") &&
                    !chessBoard.board[i][j].getSymbol().equals("K")) {
                if (!chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("Q") ||
                        !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].getSymbol().equals("B")) {
                    System.out.println("вам будет поставлен шах поэтому");
                    return true;
                } else break;
            } else break;
        }
        return false;
    }
}
