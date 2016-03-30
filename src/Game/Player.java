package Game;

import java.util.ArrayList;
import java.util.List;

import Pieces.*;

public class Player {
	private final int BOARD_SIZE = 8 * 8; //8 x 8 board
	private final int PAWNS = 8;
	private final int SECOND_ROW = 8; //adds eight to initialize pawns

	private List<Piece> pieces = new ArrayList<>();

	//determines alliance based on the color character sent - 'b' or 'w'
	private char color;

	public Player(char color) {
		this.color = color;
	}

	public void initPlayerPieces() {
		if (color == 'w') {
			// place pawns for white
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(SECOND_ROW + i));
			pieces.add(new Rook(0));
			pieces.add(new Rook(7));
			pieces.add(new Knight(1));
			pieces.add(new Knight(6));
			pieces.add(new Bishop(2));
			pieces.add(new Bishop(5));
			pieces.add(new King(3));
			pieces.add(new Queen(4));
		}else {
			// places pawns for black
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(((BOARD_SIZE - 1) - SECOND_ROW) - i)); //subtract one from BOARD_SIZE because arrays start at 0
			pieces.add(new Rook(56));
			pieces.add(new Rook(63));
			pieces.add(new Knight(57));
			pieces.add(new Knight(62));
			pieces.add(new Bishop(58));
			pieces.add(new Bishop(61));
			pieces.add(new King(59));
			pieces.add(new Queen(60));
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}
	
	public boolean isWhite(){
		if (color == 'w')
			return true;
		return false;
	}
}
