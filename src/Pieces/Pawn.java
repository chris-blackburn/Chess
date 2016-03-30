package Pieces;

import Game.Player;

public class Pawn extends Piece{
	
	private boolean isFirstMove = true;
	int[] CANDIDATE_MOVES = {7, 8, 9, 16}; //can move up one (+8), up two (+16), or diagonal to capture (+7, +9)

	public Pawn(int pos) {
		super(pos);
		ID = 'p';
	}

	@Override
	public char getID() {
		return ID;
	}

	@Override
	public boolean isMoveValid(int newPos) {
		if (pos + newPos < 64 || pos - newPos > 64) //can't go outside the board
			return false;
		
		//for white
		int move = newPos - pos;
		if (move == CANDIDATE_MOVES[3] && isFirstMove){
			isFirstMove = false;
			return true;
		}else if (move == CANDIDATE_MOVES[0] || move == CANDIDATE_MOVES[1] || move == CANDIDATE_MOVES[2])
				return true;
		return false;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}
	
	/*public boolean isUpgradeable(){
		if ((pos > 55 && Player.isWhite()) || (pos < 8 && !Player.isWhite())) //is the pawn on the opposite side of the board
			return true;
		return false;
	}*/

}
