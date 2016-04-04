package Game;

import java.util.Scanner;

public class Game {

	private static Board board;

	public Game() {
		startGameDebug();
	}
	
	public void startGameDebug() {
		board = new Board();
		Player currentPlayer = board.getCurrentPlayer();
		int pos = -1, destination = -1;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		do {
			currentPlayer = board.getCurrentPlayer();
			System.out.println(currentPlayer);
			
			System.out.print("Current Piece Position? ");
			pos = scan.nextInt();
			System.out.print("Target Position? ");
			destination = scan.nextInt();
			
			if (currentPlayer.moveExists(pos, destination)) {
				currentPlayer.makeMove(pos, destination);
			} else {
				while (!currentPlayer.moveExists(pos, destination)) {
					System.out.println("Invalid Move, Try Again...");
					
					System.out.print("Current Piece Position? ");
					pos = scan.nextInt();
					System.out.print("Target Position? ");
					destination = scan.nextInt();
					
					currentPlayer.makeMove(pos, destination);
				}
			}
			
			board.updateBoard();
			board.switchCurrentPlayer();
			
		} while (true); //no check mate exists
		
		//scan.close();
	}
	
	public Board getBoard() {
		return board;
	}
}
