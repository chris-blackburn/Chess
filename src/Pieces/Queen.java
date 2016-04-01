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
		int destination;

		for (int currentPossibilty : CANDIDATE_MOVES){
			destination = pos;
			while (Exceptions.posExists(destination)) { // existence and anti-wrapping/exceptions to candidate move rules
				destination += currentPossibilty;
				if (Exceptions.posExists(destination) && !Exceptions.isWrapping(this, currentPossibilty)){
					if (!board[destination].isOccupied()){
						legalMoves.add(new Move());
					}else if (board[destination].isOccupied()){
						if (board[destination].getPiece().getColor() != color)
							legalMoves.add(new Move());
					}
					break;
				}
			}
		}
		return legalMoves;
	}
	
}
