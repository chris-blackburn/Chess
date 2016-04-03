package Game;

public class Move {
	
	private final int pos, destination;
	private final Board board;
	
	public Move(int pos, int destination, Board board) {
		this.pos = pos;
		this.destination = destination;
		this.board = board;
	}
	
	public void executeMove() {
		board.getTile(destination).setPiece(board.getTile(pos).getPiece());
		board.getTile(pos).setPiece(null);
	}
}
