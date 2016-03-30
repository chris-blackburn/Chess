package Pieces;

public abstract class Piece {
	
	protected char ID;
	protected int[] CANDIDATE_MOVES = new int[0];

	protected int pos;

	public Piece(int pos) {
		this.pos = pos;
		ID = 0;
	}
	
	public abstract char getID();
	
	//checks if the movement submitted is valid
	public abstract boolean isMoveValid();

	//simple movement of the piece
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}
}
