package Game;

import Pieces.*;

public class Game {
	private Player white = new Player('w');
	private Player black = new Player('b');

	private Board board = new Board();

	public void main(String args[]) {
		board.initBoard(white);
		board.initBoard(black);
	}

}
