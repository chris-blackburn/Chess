package Pieces;

public class King extends Piece{
	
	private final static int[] CANDIDATE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9}; //all spaces surrounding the king

	public King(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'K';
		else
			ID = 'k';
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
