package Game;

import java.util.List;

import Pieces.*;

public class Board {
	
	private Tile[][] board = new Tile[8][8];

	public Board(){
		//creates the blank board
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
					board[i][j] = new Tile(null);
	}
	
	public void initBoard(Player player){
		//grabs coordinates and pieces from each player to initialize board
		List<Piece> pieces = player.getPieces();
		for (Piece piece : pieces)
			board[piece.getX()][piece.getY()].setPiece(piece);
	}
}
