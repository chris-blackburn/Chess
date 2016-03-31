package Game;

public class Game {
	private static Player white = new Player('w');
	private static Player black = new Player('b');

	private static Board board = new Board();

	public static void main(String args[]) {
		initBoard();
		System.out.println(board);
		board.printBoard();
	}

	public static void initBoard() {
		white.initPlayerPieces();
		board.fillBoard(white);

		black.initPlayerPieces();
		board.fillBoard(black);
	}

}
