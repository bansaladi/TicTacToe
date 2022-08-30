package tictactoe;

public class Board {

	private char board[][];
	private int boardsize= 3;
	private char P1symbol, P2symbol;
	
	private int count;
	private static final char Empty = ' ';
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALIDMOVE = 5;
	
	public Board (char P1symbol, char P2symbol) {
		board = new char[boardsize][boardsize];
		for (int i = 0; i < boardsize; i++) {
			for (int j = 0; j < boardsize; j++) {
				board[i][j] = Empty;
			}
		}
		
		this.P1symbol = P1symbol;
		this.P2symbol = P2symbol;
	}
	
	public int move(char symbol, int x, int y) {
		if (x < 0 || x >= boardsize || y < 0 || y >= boardsize || board[x][y] != Empty) {
			return INVALIDMOVE;
		}
		
		board[x][y] = symbol;
		count++;
		
		//ROW
		if (board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == P1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		//COLUMN
		if (board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == P1symbol ? PLAYER1WINS : PLAYER2WINS;
		} 
		
		//DIAGONALS
		if (board[0][0] != Empty && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return symbol == P1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		
		if (board[0][2] != Empty && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return symbol == P1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		
		if (count == boardsize * boardsize) {
			return DRAW;
		}
		return INCOMPLETE;
	}
	
	public void print() {
		System.out.println("---------------");
		for (int i = 0; i < boardsize; i++) {
			for (int j = 0; j < boardsize;j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
	}

	
}
