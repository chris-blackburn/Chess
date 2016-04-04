package Game;

import java.util.Collection;
import java.util.List;

import Pieces.Piece;

public class Player {
	
	private Collection<Piece> activePieces;
	private Collection<Move> possibleMoves;
	private final Piece king;
	
	public Player(Collection<Piece> activePieces, List<Move> possibleMoves) {
		this.activePieces = activePieces;
		this.possibleMoves = possibleMoves;
		king = getKing();
	}	
	
	public void makeMove(int pos, int destination) {
		for (Move move : possibleMoves)
			if (move.hasCoordinates(pos, destination))
				move.executeCurrentMove();
	}
	
	public boolean moveExists(int pos, int destination) {
		for (Move move : possibleMoves)
			if (move.hasCoordinates(pos, destination))
				return true;
		return false;
	}
	
	//to be used for check, check mate etc.
	private Piece getKing() {
		for (Piece piece : activePieces)
			if(piece.getID() == 'K' || piece.getID() == 'k')
				return piece;
		return null;
	}

	public void updateLists(List<Piece> activePieces, List<Move> possibleMoves) {
		this.activePieces = activePieces;
		this.possibleMoves = possibleMoves;
	}
	
	public String toString() {
		if (king.getID() == 'K')
			return "White:";
		return "Black:";
	}
}
