package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Exceptions;
import Game.Move;
import Game.Tile;

public class Pawn extends Piece {

	private boolean isFirstMove = true;

	private final static int[] CANDIDATE_MOVES = { 7, 8, 9, 16 }; // can move up one (+8), up two for first move (+16), or diagonal to capture (+7, +9)

	public Pawn(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'P';
		else
			ID = 'p';
	}

	@Override
	public List<Move> calculatePossibleMoves(Tile[] board) {
		List<Move> legalMoves = new ArrayList<>();
		int destination;
		
		for (int currentPossibilty : CANDIDATE_MOVES){
			destination = pos + currentPossibilty;
			if(Exceptions.posExists(destination) && !Exceptions.isWrapping(ID, pos, currentPossibilty)){ // existance and anti-wrapping/exceptions to candidate move rules
				if (!board[destination].isOccupied() /*and doesn't place you in check */){
					legalMoves.add(new Move());
				}else if (board[destination].isOccupied() /*and doesn't place you in check */){
					if (board[destination].getPiece().getColor() != color)
						legalMoves.add(new Move());
				}
			}
		}
		return legalMoves;
	}

	/*
	 * public boolean promotion(){ //when pawn reaches other end of the board
	 * return false; }
	 */

}
