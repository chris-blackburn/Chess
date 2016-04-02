package Game;



public class Player {
	
}
	
	//the old Player class
	/*
	private final int PAWNS = 8;
	private final int SECOND_ROW = 8; //adds or subtracts eight to initialize pawns

	private List<Piece> pieces = new ArrayList<>();

	//determines alliance based on the color character sent - 'b' or 'w'
	private char color;

	public Player(char color) {
		this.color = color;
	}

	public void initPlayerPieces() {
		if (color == 'b') {
			// place pawns for black
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(SECOND_ROW + i, color));
			pieces.add(new Rook(0, color));
			pieces.add(new Rook(7, color));
			pieces.add(new Knight(1, color));
			pieces.add(new Knight(6, color));
			pieces.add(new Bishop(2, color));
			pieces.add(new Bishop(5, color));
			pieces.add(new King(3, color));
			pieces.add(new Queen(4, color));
		}else {
			// places pawns for white
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(((Board.BOARD_SIZE - 1) - SECOND_ROW) - i, color)); //subtract one from BOARD_SIZE because arrays start at 0
			pieces.add(new Rook(56, color));
			pieces.add(new Rook(63, color));
			pieces.add(new Knight(57, color));
			pieces.add(new Knight(62, color));
			pieces.add(new Bishop(58, color));
			pieces.add(new Bishop(61, color));
			pieces.add(new King(59, color));
			pieces.add(new Queen(60, color));
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}
	*/
