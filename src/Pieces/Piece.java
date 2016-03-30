package Pieces;

public abstract class Piece {

	private int x, y;

	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isMoveValid(int fromX, int fromY, int toX, int toY){
		//to keep moving nowhere from being a valid move
		if (fromX == toX && fromY == toY)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
