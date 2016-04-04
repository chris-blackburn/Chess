package Game;

import java.util.Collection;

import Pieces.Piece;

public class Player {
	
	private final char color;
	private Collection<Piece> activePieces;
	private final Piece king;
	
	
	public Player(Collection<Piece> activePieces) {
		this.activePieces = activePieces;
		king = getKing();
		color = king.getColor();
	}	
	
	public void makeMove(Move move) {
		move.executeMove();
	}
	
	//to be used for check, check mate etc.
	private Piece getKing() {
		for (Piece piece : activePieces)
			if(piece.getID() == 'K' || piece.getID() == 'k')
				return piece;

		return null;
	}
	
	public char getColor() {
		return color;
	}
}
