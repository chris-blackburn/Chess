package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Board;
import Game.Move;

public class Rook extends Piece{
	
	private final static int[] CANDIDATE_MOVES = {-8, -1, 1, 8}; //multiples of 1 convert to horizontal movements, multiples of 8 convert to vertical movements

	public Rook(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'R';
		else
			ID = 'r';
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
