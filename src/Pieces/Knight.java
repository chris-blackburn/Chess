package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Board;
import Game.Move;

public class Knight extends Piece{
	
	private final static int[] CANDIDATE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17}; // all 8 possible moves, represents the 'L' pattern of the knights movement

	public Knight(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'N';
		else
			ID = 'n';
	}

	// makes a list of possible moves, exceptions/anti-wrapping not in place
	@Override
	public List<Move> calculatePossibleMoves(Board board) {
		List<Move> legalMoves = new ArrayList<>();
		int destination;

		for (int currentPossibilty : CANDIDATE_MOVES){
			destination = pos + currentPossibilty;
			if(Exceptions.posExists(destination) && Exceptions.isWrapping(this, currentPossibilty, destination)){ // existence and anti-wrapping/exceptions to candidate move rules
				if (!board.getTile(destination).isOccupied()){
					legalMoves.add(new Move(pos, destination, board));
				}else if (board.getTile(destination).isOccupied()){
					if (board.getTile(destination).getPiece().getColor() != color)
						legalMoves.add(new Move(pos, destination, board));
				}
			}
		}
		return legalMoves;
	}

}
