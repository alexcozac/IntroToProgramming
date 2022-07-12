package Connect6;

public class Grid {

	static char[][] grid = new char[8][9];
	static int rows = grid.length;
	static int columns = grid[0].length;

	public Grid() {
		for (int i = 0; i < rows; i++) {	
			for (int j = 0; j < columns; j++) {
				grid[i][j] = 'G';
			}
		}
		
	}
	
}
