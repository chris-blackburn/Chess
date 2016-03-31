package Pieces;

public class Pawn extends Piece {

	// private boolean isFirstMove = true; //add 8 twice if desired during first
	// move
	private final static int[] CANDIDATE_MOVES = { 7, 8, 9 }; // can move up one (+8), or diagonal to capture (+7, +9)

	public Pawn(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'P';
		else
			ID = 'p';
	}

	@Override
	public char getID() {
		return ID;
	}

	

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public char getColor() {
		return color;
	}

	/*
	 * public boolean promotion(){ //when pawn reaches other end of the board
	 * return false; }
	 */

}
