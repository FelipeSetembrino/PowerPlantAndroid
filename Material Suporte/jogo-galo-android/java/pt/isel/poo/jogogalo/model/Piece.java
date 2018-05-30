package pt.isel.poo.jogogalo.model;

public enum Piece {
    CROSS, CIRCLE;

    public Piece other() {
        return this==CROSS ? CIRCLE : CROSS;
    }

    public boolean isCross() {
        return this==CROSS;
    }
};