package Game;

import java.util.ArrayList;
import java.util.List;

import Pieces.*;

public class Player {
	private final int PAWNS = 8;

	private List<Piece> pieces = new ArrayList<>();

	private char color;

	public Player(char color) {
		this.color = color;
	}

	public void initPlayerPieces() {
		if (color == 'w') {
			// place pawns for white
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(i, 2));/*
			pieces.add(new Rook(0, 0));
			pieces.add(new Rook(7, 0));
			pieces.add(new Bishop(2, 0));
			pieces.add(new Bishop(5, 0));
			pieces.add(new Knight(1, 0));
			pieces.add(new Knight(6, 0));
			pieces.add(new King(4, 0));
			pieces.add(new Queen(3, 0));*/
		} else {
			// places pawns for black
			for (int i = 0; i < PAWNS; i++)
				pieces.add(new Pawn(i, 6));/*
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
}
