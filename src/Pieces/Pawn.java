package Pieces;

import java.util.ArrayList;
import java.util.List;

import Game.Exceptions;
import Game.Move;
import Game.Tile;

public class Pawn extends Piece {

	private final static int[] CANDIDATE_MOVES = { 7, 8, 9, 16 }; // can move up one (+8), up two for first move (+16), or diagonal to capture (+7, +9)

	private boolean isFirstMove = true;
	
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
			if(Exceptions.posExists(destination)){ // existance
				if (currentPossibilty == 8 && !board[destination].isOccupied()){ // normal moves
					legalMoves.add(new Move());
				} else if(currentPossibilty == 16 && !board[destination].isOccupied() /*check if is first move and change to false after first move*/){ // jump move
					legalMoves.add(new Move());
				} else if(!Exceptions.isWrapping(this, currentPossibilty) && board[destination].isOccupied() && board[destination].getPiece().getColor() != color){ // capture moves
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
	
	 private boolean isDuePromotion(){ //when pawn reaches other end of the board
		 if (color == 'w' && Exceptions.FIRST_ROW[pos]){
			 return true;
		 }else if (color == 'b' && Exceptions.EIGTH_ROW[pos])
			 return true;
		 return false; 
	 }
	 

}
