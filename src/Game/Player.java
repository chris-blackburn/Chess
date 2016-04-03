package Game;

import java.util.Collection;

import Pieces.Piece;

public class Player {
	
	private final char color;
	private Board board;
	private Collection<Piece> activePieces;
	private final Piece king;
	
	
	public Player(Board board, Collection<Piece> activePieces) {
		this.board = board;
		this.activePieces = activePieces;
		king = getKing();
		color = king.getID();
	}	
	
	private Piece getKing() {
		for (Piece piece : activePieces)
			if(piece.getID() == 'K' || piece.getID() == 'k')
				return piece;
		return null;
	}
	
	public void makeMove(Move move) {
		move.executeMove();
	}
	
	//TODO get dese done l8a
	public boolean isInCheck() {
		return false;
	}
	
	public boolean isInCheckMate() {
		return false;
	}
	
	public boolean isInStaleMate() {
		return false;
	}
	
}
