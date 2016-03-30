package Game;

public class Game {
	private Player white = new Player('w');
	private Player black = new Player('b');

	private Board board = new Board();

	public void main(String args[]) {
		
	}
	
	public void initBoard(){
		board.initBoard(white);
		board.initBoard(black);
	}
	
	public Board getBoard(){
		return board;
	}

}
