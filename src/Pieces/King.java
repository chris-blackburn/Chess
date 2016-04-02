package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Board;
import Game.Move;

public class King extends Piece{
	
	private final static int[] CANDIDATE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9}; //all spaces surrounding the king

	public King(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'K';
		else
			ID = 'k';
	}

	@Override
	public List<Move> calculatePossibleMoves(Board board) {
		List<Move> legalMoves = new ArrayList<>();
		int destination;
		
		for (int currentPossibilty : CANDIDATE_MOVES){
			destination = pos + currentPossibilty;
			if(Exceptions.posExists(destination) && !Exceptions.isWrapping(this, currentPossibilty)){ // existence and anti-wrapping/exceptions to candidate move rules
				if (!board.getTile(destination).isOccupied() /*and doesn't place you in check */){
					legalMoves.add(new Move());
				}else if (board.getTile(destination).isOccupied() /*and doesn't place you in check */){
					if (board.getTile(destination).getPiece().getColor() != color)
						legalMoves.add(new Move());
				}
			}
		}
		return legalMoves;
	}

}
