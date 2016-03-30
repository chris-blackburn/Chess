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
				pieces.add(new Pawn(SECOND_ROW + i));/*
			pieces.add(new Rook(0, 0));
			pieces.add(new Rook(7, 0));
			pieces.add(new Bishop(2, 0));
			pieces.add(new Bishop(5, 0));
			pieces.add(new Knight(1, 0));
			pieces.add(new Knight(6, 0));
			pieces.add(new King(4, 0));
			pieces.add(new Queen(3, 0));*/
		}else {
			// places pawns for black
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(((BOARD_SIZE - 1) - SECOND_ROW) - i));/*//subtract one from BOARD_SIZE because arrays start at 0
			pieces.add(new Rook(0, 7));
			pieces.add(new Rook(7, 7));
			pieces.add(new Bishop(2, 7));
			pieces.add(new Bishop(5, 7));
			pieces.add(new Knight(1, 7));
			pieces.add(new Knight(6, 7));
			pieces.add(new King(4, 7));
			pieces.add(new Queen(3, 7));*/
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
