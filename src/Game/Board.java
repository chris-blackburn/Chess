package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Pieces.*;

public class Board {
	
	private final Player whitePlayer;
	private final Player blackPlayer;
	
	// algebraic notation of the board, will be used to print moves
	private final String[] algebraicNotation = { "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", "a7", "b7", "c7", "d7", "e7",
			"f7", "g7", "h7", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", "a5", "b5", "c5", "d5", "e5", "f5", "g5",
			"h5", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", "a2",
			"b2", "c2", "d2", "e2", "f2", "g2", "h2", "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" };
 
	private static final int BOARD_SIZE = 8 * 8;
	
	private final Collection<Piece> initPieces = setPieces();
	private Tile[] board;
	
	// finds all active pieces on the board
	private Collection<Piece> whitePieces;
	private Collection<Piece> blackPieces;
	
	private void calculateActivePieces() {
		List<Piece> activePieces = new ArrayList<>();
		// find all white pieces
		for (Tile tile : board)
			if (tile.isOccupied()) 
				if (tile.getPiece().getColor() == 'w') 
					activePieces.add(tile.getPiece());
		whitePieces = activePieces; 
		
		activePieces.clear();
	 	
		// find all black pieces
		for (Tile tile : board)
			if (tile.isOccupied()) 
				if (tile.getPiece().getColor() == 'b') 
					activePieces.add(tile.getPiece());
		blackPieces = activePieces;
		
		activePieces.clear();
	}
	
	Collection<Move> whitePossibleMoves;
	Collection<Move> blackPossibleMoves;
	
	private Collection<Move> calculatePossibleMoves(Collection<Piece> pieces) {
		List<Move> possibleMoves = new ArrayList<>();
		for (Piece piece : pieces)
			possibleMoves.addAll(piece.calculatePossibleMoves(this));
		return possibleMoves;
	}
	
	public Board() {
		board = new Tile[BOARD_SIZE];
		
		// fills board with null Tiles
		for (int i = 0; i < BOARD_SIZE; i++)
			board[i] = new Tile();
		
		//adds all pieces in starting positions
		for (Piece piece : initPieces)
			board[piece.getPos()].setPiece(piece);
		
		updateBoard();	
		
		whitePlayer = new Player(this, whitePieces);
		blackPlayer = new Player(this, blackPieces);
	}
	
	public void updateBoard() {
		
		calculateActivePieces();
		
		whitePossibleMoves = calculatePossibleMoves(whitePieces);
		blackPossibleMoves = calculatePossibleMoves(blackPieces);
	}
	
	public Tile getTile(int pos) {
		return board[pos];
	}
	
	private List<Piece> setPieces() {
		
		final int SECOND_ROW = 8; // add or subtract 8 to get the second row for each color (to initiate pawns)
		
		List<Piece> pieces = new ArrayList<>();
		
		char color = 'b';
		
		// place pawns for black
		for (int i = 0; i < 8; i++)
			pieces.add(new Pawn(SECOND_ROW + i, color));
		pieces.add(new Rook(0, color));
		pieces.add(new Rook(7, color));
		pieces.add(new Knight(1, color));
		pieces.add(new Knight(6, color));
		pieces.add(new Bishop(2, color));
		pieces.add(new Bishop(5, color));
		pieces.add(new King(3, color));
		pieces.add(new Queen(4, color));
		
		color = 'w';

		// places pawns for white
		for (int i = 0; i < 8; i++)
			pieces.add(new Pawn(((Board.BOARD_SIZE - 1) - SECOND_ROW) - i, color)); //subtract one from BOARD_SIZE because arrays start at 0
		pieces.add(new Rook(56, color));
		pieces.add(new Rook(63, color));
		pieces.add(new Knight(57, color));
		pieces.add(new Knight(62, color));
		pieces.add(new Bishop(58, color));
		pieces.add(new Bishop(61, color));
		pieces.add(new King(59, color));
		pieces.add(new Queen(60, color));
		
		return pieces;
	}
	
	public String toString() {
		String string = new String();
		for (int i = 1; i <= BOARD_SIZE; i++)
			if (i % 8 != 0)
				if (board[i - 1].getPiece() == null)
					string += "@  ";
				else
					string += board[i - 1].getPiece().getID() + "  ";
			else if (board[i - 1].getPiece() == null)
				string += "@  \n";
			else
				string += board[i - 1].getPiece().getID() + " \n";
		return string;
	}
}
