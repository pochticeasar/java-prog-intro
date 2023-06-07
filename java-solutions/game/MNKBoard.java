package game;

import java.util.Arrays;
import java.util.Map;

import static java.lang.Math.min;

public class MNKBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    private Cell turn;
    private final int k;
    private final int n;
    private final int m;

    public MNKBoard(int m, int n, int k) {
        field = new Cell[m][n];
        this.k = k;
        this.n = n;
        this.m = m;
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();
        if (checkWin()) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (field[r][c] == Cell.E) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    private boolean checkWin() {
        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (field[r][c] == turn) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == k) {
                    return true;
                }
            }

        }
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < m; r++) {
                if (field[r][c] == turn) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == k) {
                    return true;
                }
            }
        }
        int in = min(n, m);
        int count = 0;
        for (int i = 0; i < in; i++) {
            if (field[i][i] == turn) {
                count++;
            } else {
                count = 0;
            }
            if(count == k)
                return true;
        }
        count = 0;
        for (int i = 0; i < in; i++) {
            if(field[i][n - i - 1] == turn) {
                count++;
            } else {
                count = 0;
            }
            if(count == k)
                return true;
        }
        return false;
    }
    public String indent(int m) {
        return "\t";
    }
    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getCol() && move.getCol() < n
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(indent(m));
        for (int i = 1; i <= n; i++) {
            ans.append(i);
            ans.append("\t");
        }
        ans.append(System.lineSeparator());
        for (int r = 0; r < m; r++) {
            ans.append(r + 1);
            ans.append(indent(r + 1));
            for (Cell cell : field[r]) {
                ans.append(CELL_TO_STRING.get(cell));
                ans.append(indent(r + 1));
            }
            ans.append(System.lineSeparator());
        }
        ans.setLength(ans.length() - System.lineSeparator().length());
        return ans.toString();
    }
}
