package Game;

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

	public static boolean isWrapping(char ID, int pos, int candidate) {
		// bishop exceptions
		if (ID == 'b' || ID == 'B')
			if (FIRST_COLUMN[pos]) {
				return (candidate == -9 || candidate == 7);
			} else if (SECOND_COLUMN[pos])
				return (candidate == -7 || candidate == 9);

		// king exceptions
		if (ID == 'k' || ID == 'K')
			return true;

		// knight exceptions
		if (ID == 'n' || ID == 'N')
			if (FIRST_COLUMN[pos]) {
				return (candidate == -17 || candidate == -10 || candidate == 6 || candidate == 15);
			} else if (SECOND_COLUMN[pos]) {
				return (candidate == -10 || candidate == 6);
			} else if (SEVENTH_COLUMN[pos]) {
				return (candidate == -6 || candidate == 10);
			} else if (EIGTH_COLUMN[pos])
				return (candidate == -15 || candidate == -6 || candidate == 10 || candidate == 17);

		// pawn exceptions
		if (ID == 'p' || ID == 'P')
			return true;

		// queen exceptions
		if (ID == 'q' || ID == 'Q')
			return true;

		// rook exceptions
		if (ID == 'r' || ID == 'R')
			return true;

		return true;
	}

}
