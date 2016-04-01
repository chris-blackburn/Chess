package Game;

import Pieces.Piece;

public class Exceptions {

	public static final int BOARD_SIZE = 8 * 8;

	public static boolean posExists(int destination) {
		return destination >= 0 && destination < BOARD_SIZE;
	}

	public static final boolean[] FIRST_COLUMN = defineColumn(0);
	public static final boolean[] SECOND_COLUMN = defineColumn(1);
	public static final boolean[] SEVENTH_COLUMN = defineColumn(6);
	public static final boolean[] EIGTH_COLUMN = defineColumn(7);

	private static boolean[] defineColumn(int colNum) {
		final boolean[] column = new boolean[BOARD_SIZE];
		do {
			column[colNum] = true;
			colNum += 8;
		} while (colNum < BOARD_SIZE);
		return column;
	}
	
	public static final boolean[] FIRST_ROW = defineRow(0);
	public static final boolean[] SECOND_ROW = defineRow(1);
	public static final boolean[] SEVENTH_ROW = defineRow(6);
	public static final boolean[] EIGTH_ROW = defineRow(7);
	
	private static boolean[] defineRow(int rowNum){
		final boolean[] row = new boolean[BOARD_SIZE];
		for (int i = 0; i < 8; i++)
			row[rowNum + i] = true;
		return row;
	}

	public static boolean isWrapping(Piece piece, int candidate) { // prevents wrapping around the board
		// bishop exceptions
		if (piece.getID() == 'b' || piece.getID() == 'B')
			if (FIRST_COLUMN[piece.getPos()]) {
				return (candidate == -9 || candidate == 7);
			} else if (EIGTH_COLUMN[piece.getPos()])
				return (candidate == -7 || candidate == 9);

		// king exceptions
		if (piece.getID() == 'k' || piece.getID() == 'K')
			if (FIRST_COLUMN[piece.getPos()]) {
				return (candidate == -9 || candidate == -1 || candidate == 7);
			} else if (EIGTH_COLUMN[piece.getPos()])
				return (candidate == -7 || candidate == 1 || candidate == 9);

		// knight exceptions
		if (piece.getID() == 'n' || piece.getID() == 'N')
			if (FIRST_COLUMN[piece.getPos()]) {
				return (candidate == -17 || candidate == -10 || candidate == 6 || candidate == 15);
			} else if (SECOND_COLUMN[piece.getPos()]) {
				return (candidate == -10 || candidate == 6);
			} else if (SEVENTH_COLUMN[piece.getPos()]) {
				return (candidate == -6 || candidate == 10);
			} else if (EIGTH_COLUMN[piece.getPos()])
				return (candidate == -15 || candidate == -6 || candidate == 10 || candidate == 17);

		// pawn exceptions
		if (piece.getID() == 'p' || piece.getID() == 'P')
			if (FIRST_COLUMN[piece.getPos()] && piece.getColor() == 'b') {
				return (candidate == 7);
			} else if (EIGTH_COLUMN[piece.getPos()] && piece.getColor() == 'w')
				return (candidate == 7);

		// queen exceptions
		if (piece.getID() == 'q' || piece.getID() == 'Q')
			if (FIRST_COLUMN[piece.getPos()]) {
				return (candidate == -9 || candidate == -1 || candidate == 7);
			} else if (EIGTH_COLUMN[piece.getPos()])
				return (candidate == -7 || candidate == 1 || candidate == 9);

		// rook exceptions
		if (piece.getID() == 'r' || piece.getID() == 'R')
			if (FIRST_COLUMN[piece.getPos()]) {
				return (candidate == -1);
			} else if (EIGTH_COLUMN[piece.getPos()])
				return (candidate == 1);

		return false;
	}

}
