
public class TicTacToeGame {
	char [][] board = new char[3][3];
	
	public void getBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = '-';
			}
		}
	}
	
}
