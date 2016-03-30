package Pieces;

public class Bishop extends Piece{
	
	int[] CANDIDATE_MOVES = {-9, -7, 7, 9}; //multiples of 7 or 9 convert to diagonal movements

	public Bishop(int pos) {
		super(pos);
		ID = 'B';
	}

	@Override
	public char getID() {
		return ID;
	}

	@Override
	public boolean isMoveValid() {
		return false;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}

}
