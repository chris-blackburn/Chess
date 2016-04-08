package Game;

import java.util.ArrayList;
import java.util.List;

import Pieces.*;

public class Board {

	private static final int BOARD_SIZE = 8 * 8;

	private final List<Piece> initPieces = setPieces();
	
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

	// lists of all active pieces on the board
	private List<Piece> whitePieces = new ArrayList<>();
	private List<Piece> blackPieces = new ArrayList<>();
	
	// calculate all the active pieces for the current board state
	private void calculateActivePieces() {
		// find all white pieces
		for (Tile tile : board)
			if (tile.isOccupied()) 
				if (tile.getPiece().getColor() == 'w') 
					whitePieces.add(tile.getPiece());
				else
					blackPieces.add(tile.getPiece());
	}
	
	// lists of all possible moves on the board
	List<Move> whitePossibleMoves;
	List<Move> blackPossibleMoves;
	
	// calculate all the possible moves for the current board state
	private List<Move> calculatePossibleMoves(List<Piece> pieces) {
		List<Move> possibleMoves = new ArrayList<>();
		for (Piece piece : pieces)
			possibleMoves.addAll(piece.calculatePossibleMoves(this));
		return possibleMoves;
	}
	
	private final Player whitePlayer;
	private final Player blackPlayer;
	public boolean currentPlayerIsWhite = true;
	
	public void switchCurrentPlayer() {
		currentPlayerIsWhite = !currentPlayerIsWhite;
	}
	
	public Player getCurrentPlayer() {
		if (currentPlayerIsWhite){
			return whitePlayer;
		} else
			return blackPlayer;
	}
	
	private Tile[] board;
	
	public Board() {
		board = new Tile[BOARD_SIZE];
		
		// fills board with null Tiles
		for (int i = 0; i < BOARD_SIZE; i++)
			board[i] = new Tile();
		
		//adds all pieces in starting positions
		for (Piece piece : initPieces)
			board[piece.getPos()].setPiece(piece);
		
		calculateActivePieces();
		
		whitePossibleMoves = calculatePossibleMoves(whitePieces);
		blackPossibleMoves = calculatePossibleMoves(blackPieces);
		
		whitePlayer = new Player(whitePieces, whitePossibleMoves);
		blackPlayer = new Player(blackPieces, blackPossibleMoves);
		
		System.out.println(this);
	}
	
	public void updateBoard() {
		// clears active pieces lists
		whitePieces.clear();
		blackPieces.clear();
		
		calculateActivePieces();
		
		// clears possible moves lists
		whitePossibleMoves.clear();
		blackPossibleMoves.clear();
		
		// refreshes all the lists
		whitePossibleMoves = calculatePossibleMoves(whitePieces);
		blackPossibleMoves = calculatePossibleMoves(blackPieces);
		
		whitePlayer.updateLists(whitePieces, whitePossibleMoves);
		blackPlayer.updateLists(blackPieces, blackPossibleMoves);
		
		System.out.println(this);
	}
	
	public Tile getTile(int pos) {
		return board[pos];
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
