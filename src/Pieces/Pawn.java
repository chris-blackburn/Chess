package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Exceptions;
import Game.Move;
import Game.Tile;

public class Pawn extends Piece {

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
			destination = pos + (currentPossibilty * direction());
			if(Exceptions.posExists(destination)){ // existence
				if (currentPossibilty == 8 && !board[destination].isOccupied()){ // normal moves
					legalMoves.add(new Move());
				} else if(currentPossibilty == 16 
						&& !board[destination].isOccupied() 
						&& isJumpingOtherPiece(board, destination)
						&& isFirstMove()){ // jump move
					legalMoves.add(new Move());
				} else if(!Exceptions.isWrapping(this, currentPossibilty) // capture moves
						&& board[destination].isOccupied()
						&& board[destination].getPiece().getColor() != color){
					legalMoves.add(new Move());
				}
			}
		}
		return legalMoves;
	}
	
	private final int direction(){
		if (color == 'w')
			return -1;
		return 1;
	}
	
	private boolean isFirstMove(){
		if (color == 'w' && Exceptions.SEVENTH_ROW[pos]){
			return true;
		} else if (color == 'b' && Exceptions.SECOND_ROW[pos]){
			return true;
		}
		return false;
	}
	
	private boolean isJumpingOtherPiece(Tile[] board, int destination){
		if (color == 'w' && board[destination + 8].isOccupied())
			return true;
		if (color == 'b' && board[destination - 8].isOccupied())
			return true;
		return false;
	}
	
	/*
	private boolean isDuePromotion(){ //when pawn reaches other end of the board
		if (color == 'w' && Exceptions.FIRST_ROW[pos]){
			return true;
		}else if (color == 'b' && Exceptions.EIGTH_ROW[pos])
			return true;
		return false; 
	}
	*/
}
