package Pieces;

public abstract class Piece {

	private int x, y;

	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract boolean isMoveValid();

	public int getLocX() {
		return x;
	}

	public int getLocY() {
		return y;
	}
}
