package Game;

import java.util.List;

import Pieces.*;

public class Board {

	private final int BOARD_SIZE = 8 * 8; // 8 x 8 board

	private Tile[] board = new Tile[BOARD_SIZE];

	//true map of the board, will be used to print moves
	private final String[] truePos = { "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "b7", "c7", "d7", "e7",
			"f7", "g7", "h7", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a5", "b5", "c5", "d5", "e5", "f5", "g5",
			"h5", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a2",
			"b2", "c2", "d2", "e2", "f2", "g2", "h2", "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"};

	public Board() {
		// creates the blank board
		for (int i = 0; i < BOARD_SIZE; i++)
			board[i] = new Tile();
	}

	public void fillBoard(Player player) {
		// grabs coordinates and pieces from each player to initialize board
		List<Piece> pieces = player.getPieces();
		for (Piece piece : pieces)
			board[piece.getPos()].setPiece(piece);
	}
	
	public Tile[] getBoard(){
		return board;
	}

	public String toString(){
		String string = new String();
		for (int i = 1; i <= BOARD_SIZE; i++)
			if (i % 8 != 0)
				if (board[i - 1].getPiece() == null)
					string += "@  ";
				else
					string += board[i - 1].getPiece().getID() + "  ";
			else
				if (board[i - 1].getPiece() == null)
					string += "@  \n";
				else
					string += board[i - 1].getPiece().getID() + " \n";
		return string;
	}
	
	public void printBoard(){
		for (int i = 1; i <= BOARD_SIZE; i++)
			if (i % 8 != 0)
				System.out.print(truePos[i - 1] + " ");
			else
				System.out.println(truePos[i - 1]);
	}
}
