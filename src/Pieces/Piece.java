package Pieces;

import java.util.List;

import Game.Board;
import Game.Move;

public abstract class Piece {

	protected char ID;

	protected int pos;
	protected char color;

	public Piece(int pos, char color) {
		this.pos = pos;
		this.color = color;
		ID = 0;
	}

	public char getID(){
		return ID;
	}
	
	// creates a list of possible moves and returns it
	public abstract List<Move> calculatePossibleMoves(Board board);

	// simple movement of the piece
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public char getColor() {
		return color;
	}

}
