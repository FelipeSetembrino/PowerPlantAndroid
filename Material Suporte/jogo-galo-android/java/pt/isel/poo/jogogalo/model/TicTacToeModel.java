package pt.isel.poo.jogogalo.model;

import java.util.ArrayList;

public class TicTacToeModel {

    public enum State {Run, Win, Tie};
    private State state = State.Run;

    private static final int SIZE = 3;
    private Piece[][] board;
    private int numberOfMoves;
    private Piece nextMove;

    public TicTacToeModel(boolean startCross) {
        board = new Piece[SIZE][SIZE];
        nextMove = startCross ? Piece.CROSS : Piece.CIRCLE;
    }

    public String getNextMoveString() {
        return nextMove.toString();
    }

    public void reset(boolean startCross) {
        for (int lin=0; lin<SIZE; ++lin) {
            for (int col=0; col<SIZE; ++col) {
                board[lin][col] = null;
            }
        }
        nextMove = startCross ? Piece.CROSS : Piece.CIRCLE;
        numberOfMoves = 0;
        state = State.Run;
    }

    public boolean touch(int lin, int col) {
        if (board[lin][col] != null)
            return false;
        board[lin][col] = nextMove;
        nextMove = nextMove.other();
        if (checkWin(lin, col))
            state = State.Win;
        if (++numberOfMoves == SIZE * SIZE)
            state = State.Tie;
        return true;
    }

    public Piece getPiece(int lin, int col) {
        return board[lin][col];
    }

    public State getState() {return state; }

    public boolean checkWin(int lin, int col) {
        return checkDiag1() || checkDiag2() || checkLin(lin) || checkCol(col);
    }

    private boolean checkCol(int col) {
        Piece p = board[0][col];
        for (int i = 1; i< SIZE; ++i)
            if (board[i][col] != p)
                return false;
        return true;
    }

    private boolean checkDiag1() {
        Piece p = board[0][0];
        if (p == null) return false;
        for (int i = 1; i< SIZE; ++i) {
            if (board[i][i]!=p)
                return false;
        }
        return true;
    }
    private boolean checkDiag2() {
        Piece p = board[0][SIZE-1];
        if (p == null) return false;
        for (int i=1; i<SIZE; ++i) {
            if (board[i][SIZE-1-i]!=p)
                return false;
        }
        return true;
    }
    private boolean checkLin(int lin) {
        Piece p = board[lin][0];
        for (int i=1; i<SIZE; ++i) {
            if (board[lin][i]!=p)
                return false;
        }
        return true;
    }
}
