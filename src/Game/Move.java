package Game;

public class Move {
	
	// algebraic notation of the board, will be used to print moves, not currently implemented
		private final String[] algebraicNotation = { "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "b7", "c7", "d7", "e7",
				"f7", "g7", "h7", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a5", "b5", "c5", "d5", "e5", "f5", "g5",
				"h5", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a2",
				"b2", "c2", "d2", "e2", "f2", "g2", "h2", "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" };
	
	private final int pos, destination;
	private final Board board;
	
	public Move(int pos, int destination, Board board) {
		this.pos = pos;
		this.destination = destination;
		this.board = board;
	}
	
	// simple movement
	public void executeMove() {
		board.getTile(destination).setPiece(board.getTile(pos).getPiece());
		board.getTile(pos).setPiece(null);
	}
	
	// simple implementation of move representation
	public String toString() {
		char pieceAtPos = board.getTile(pos).getPiece().getID();
		return pieceAtPos + algebraicNotation[pos] + " --> " + algebraicNotation[destination];
	}
}
