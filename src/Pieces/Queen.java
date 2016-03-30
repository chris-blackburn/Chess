package Pieces;

public class Queen extends Piece {
	
	private final static int[] CANDIDATE_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9}; //combination of Rook and Bishop

	public Queen(int pos, char color) {
		super(pos, color);
		if (color == 'w')
			ID = 'Q';
		else
			ID = 'q';
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
