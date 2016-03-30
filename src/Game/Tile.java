package Game;

import Pieces.Piece;

//the Tile class only contains state - whether it is null or occupied and by what piece
//the board object is an array of Tiles

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
