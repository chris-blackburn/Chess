package Pieces;

public abstract class Piece {
	
	protected final char ID = 0;
	protected final int[] CANDIDATE_MOVES = new int[0];

	private int pos;

	public Piece(int pos) {
		this.pos = pos;
	}
	
	public abstract char getID();
	
	//checks if the movement submitted is valid
	public abstract boolean isMoveValid(int fromPos, int toPos);

	//simple movement of the piece
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}
}
