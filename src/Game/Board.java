package Game;

import java.util.List;

import Pieces.*;

public class Board {
	
	private final int BOARD_SIZE = 8 * 8; //8 x 8 board
	
	private Tile[] board = new Tile[BOARD_SIZE];

	public Board(){
		//creates the blank board
		for (int i = 0; i < BOARD_SIZE; i++)
				board[i] = new Tile(null);
	}
	
	public void initBoard(Player player){
		//grabs coordinates and pieces from each player to initialize board
		List<Piece> pieces = player.getPieces();
		for (Piece piece : pieces)
			board[piece.getPos()].setPiece(piece);
	}
	
}
