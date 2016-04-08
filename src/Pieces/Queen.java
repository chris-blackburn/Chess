package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Move;
import Game.Board;

public class Queen extends Piece {
	
	private final static int[] CANDIDATE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9}; //combination of Rook and Bishop

	public Queen(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'Q';
		else
			ID = 'q';
	}

	@Override
	public List<Move> calculatePossibleMoves(Board board) {
		List<Move> legalMoves = new ArrayList<>();

		for (int currentPossibilty : CANDIDATE_MOVES){
			int destination = pos;
			while (Exceptions.posExists(destination)) { // existence and anti-wrapping/exceptions to candidate move rules
				if (Exceptions.isWrapping(this, currentPossibilty, destination))
					break;
				destination += currentPossibilty;
				if (Exceptions.posExists(destination)) {
					if (!board.getTile(destination).isOccupied()) {
						legalMoves.add(new Move(pos, destination, board));
					}else {
						if (board.getTile(destination).getPiece().getColor() != color)
							legalMoves.add(new Move(pos, destination, board));
						break;
					}
				}
			}
		}
		return legalMoves;
	}
	
}
