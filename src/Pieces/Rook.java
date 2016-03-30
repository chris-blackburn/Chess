package Pieces;

public class Rook extends Piece{
	
	private final static int[] CANDIDATE_MOVES = {-8, -1, 1, 8}; //multiples of 1 convert to horizontal movements, multiples of 8 convert to vertical movements

	public Rook(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'R';
		else
			ID = 'r';
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

}
