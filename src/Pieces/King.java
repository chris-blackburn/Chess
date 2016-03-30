package Pieces;

public class King extends Piece{
	
	int[] CANDIDATE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9};

	public King(int pos) {
		super(pos);
		ID = 'K';
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
