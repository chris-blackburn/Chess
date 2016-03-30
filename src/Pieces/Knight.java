package Pieces;

public class Knight extends Piece{
	
	int[] CANDIDATE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17}; //all 8 possible moves, represents the 'L' pattern of the knights movement

	public Knight(int pos) {
		super(pos);
		ID = 'k';
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
