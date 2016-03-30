package Game;

import Pieces.Piece;

public class Tile {
	private Piece piece;

	public Tile(Piece piece) {
		this.piece = piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
}
