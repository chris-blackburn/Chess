package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Move;
import Game.Board;

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
	public List<Move> calculatePossibleMoves(Board board) {
		List<Move> legalMoves = new ArrayList<>();
		int destination;
		
		for (int currentPossibilty : CANDIDATE_MOVES){
			destination = pos + (currentPossibilty * direction());
			if(Exceptions.posExists(destination)){ // existence
				if (currentPossibilty == 8 && !board.getTile(destination).isOccupied()){ // normal moves
					legalMoves.add(new Move(pos, destination, board));
				} else if(currentPossibilty == 16 
						&& !board.getTile(destination).isOccupied() 
						&& !isJumpingOtherPiece(board, destination)
						&& isFirstMove()){ // jump move
					legalMoves.add(new Move(pos, destination, board));
				} else if(Exceptions.isWrapping(this, currentPossibilty, destination) // capture moves
						&& board.getTile(destination).isOccupied()
						&& board.getTile(destination).getPiece().getColor() != color){
					legalMoves.add(new Move(pos, destination, board));
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
		if (color == 'w' ){
			return Exceptions.SEVENTH_ROW[pos];
		} else if (color == 'b' ){
			return Exceptions.SECOND_ROW[pos];
		}
		return false;
	}
	
	private boolean isJumpingOtherPiece(Board board, int destination){
		if (color == 'w' && board.getTile(destination + 8).isOccupied())
			return true;
		if (color == 'b' && board.getTile(destination - 8).isOccupied())
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
