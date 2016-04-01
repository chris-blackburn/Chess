package Game;

public class Game {
	private static Player white = new Player('w');
	private static Player black = new Player('b');

	private static Board board = new Board();

	public Game() {
		initBoard();
	}

	public static void initBoard() {
		// initiate white
		white.initPlayerPieces();
		board.fillBoard(white);

		// initiate black
		black.initPlayerPieces();
		board.fillBoard(black);
	}
	
	public String toString(){
		return board.toString();
	}

}
