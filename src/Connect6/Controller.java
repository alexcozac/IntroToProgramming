package Connect6;

public class Controller {

	private static char[][] grid = Grid.grid;
	private boolean turnClock = true;
	private int turnCount = 0;
	private int rows = Grid.rows;
	private int columns = Grid.columns;
	private boolean matchOutcome;
	boolean linePresent = false;

	/**
	 * Places a token inside the given column, stacking them from bottom to top
	 * 
	 * @see #checkUserLines(int, int)
	 * @param column
	 * @return integer equal to the row where the token has been placed
	 */
	public int placeToken(int column) {
		int result = rows - 1;
		for (result = rows - 1; result >= 0; result--) {
			if (grid[result][column] == 'G') {
				if (turnClock) {
					grid[result][column] = 'Y';
					checkUserLines(result, column);
					turnClock = false;
					turnCount++;
					break;
				} else {
					grid[result][column] = 'R';
					checkUserLines(result, column);
					turnClock = true;
					turnCount++;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Checks if the user formed a line of 6 in any direction. Will set {@link #matchOutcome} to True if the user wins,
	 * or false if the computer wins.
	 * @see #checkDown(Integer, Integer, char)
	 * @see #checkLeftToRight(Integer, Integer, char)
	 * @see #checkDiagonalLeft(int, int, char)
	 * @see #checkDiagonalRight(int, int, char)
	 * @param row
	 * @param column
	 * 
	 */
	public void checkUserLines(int row, int column) {
		char colorChecker;
		// UserChecker------------
		if (turnClock) {
			colorChecker = 'Y';
			if (checkDown(row, column, colorChecker)) {
				matchOutcome = true;
			}
			if (checkLeftToRight(row, column, colorChecker)) {
				matchOutcome = true;
			}
			if (checkDiagonalLeft(row, column, colorChecker)) {
				matchOutcome = true;
			}
			if (checkDiagonalRight(row, column, colorChecker)) {
				matchOutcome = true;
			}

		}
		// CpuChecker-------------
		else {
			colorChecker = 'R';
			if (checkDown(row, column, colorChecker)) {
				matchOutcome = false;
			}
			if (checkLeftToRight(row, column, colorChecker)) {
				matchOutcome = false;
			}
			if (checkDiagonalLeft(row, column, colorChecker)) {
				matchOutcome = false;
			}
			if (checkDiagonalRight(row, column, colorChecker)) {
				matchOutcome = false;
			}
		}
	}
	// TODO Only for CheckUserLines
	// ----------------------------------------------------------------------

	/**
	 * Given the column, row and colour to be checked, will keep going down until it reaches
	 * the bottom or the line is disrupted by the other colour.
	 * Notifies the computer player with all of the information gathered as well.
	 * 
	 * @param row
	 * @param column
	 * @param colorChecker
	 * @return True if line of 6 is formed
	 */
	private boolean checkDown(Integer row, Integer column, char colorChecker) {
		int count = 0;
		String coords = row.toString() + column.toString();

		while (row < rows) {
			if (grid[row][column] == colorChecker) {
				count++;
				row++;
			} else
				break;
		}
		if (count >= 6) {
			linePresent = true;
			return linePresent;
		}

		Plankton.notifyPlankton(Integer.parseInt(coords), "Vertical", colorChecker, count);
		return linePresent;

	}

	/**
	 * Given the column, row and colour to be checked, will check left to right until it reaches
	 * the edge or the line is disrupted by the other colour.
	 * Notifies the computer player with all of the information gathered as well.
	 * 
	 * @param row
	 * @param column
	 * @param colorChecker
	 * @return True if line of 6 is formed
	 */
	private boolean checkLeftToRight(Integer row, Integer column, char colorChecker) {
		int count = 0;
		int anchorColumn = column;
		Integer leftBound = null, rightBound = null;
		// Going Left
		while (column >= 0) {
			if (grid[row][column] == colorChecker) {
				count++;
				leftBound = column;
				if (column > 0) {
					column--;
				} else {
					count--;
					break;
				}
			} else {
				count--;
				break;
			}
		}
		String leftBoundCoords = row.toString() + leftBound.toString();
		Plankton.notifyPlankton(Integer.parseInt(leftBoundCoords), "HorizontalLeft" , colorChecker, count);
		// Going Right from anchorPoint
		while (anchorColumn < columns) {
			if (grid[row][anchorColumn] == colorChecker) {
				count++;
				rightBound = anchorColumn;
				anchorColumn++;
			} else
				break;
		}
		if (count >= 6) {
			linePresent = true;
			return linePresent;
		}
		String rightBoundCoords = row.toString() + rightBound.toString();
		Plankton.notifyPlankton(Integer.parseInt(rightBoundCoords), "HorizontalRight", colorChecker, count);
		return linePresent;
	}

	/**
	 * Given the column, row and colour to be checked, will check diagonally left being the upper part until it reaches
	 * the edge or the line is disrupted by the other colour.
	 * Notifies the computer player with all of the information gathered as well.
	 * 
	 * @param row
	 * @param column
	 * @param colorChecker
	 * @return True if line of 6 is formed
	 */
	private boolean checkDiagonalLeft(int row, int column, char colorChecker) {
		int count = 0;
		int anchorRow = row;
		int anchorColumn = column;
		// Going diagonal left upwards
		while (row >= 0 && column >= 0) {
			if (grid[row][column] == colorChecker) {
				count++;
				if (row > 0 && column > 0) {
					row--;
					column--;
				} else {
					count--;
					break;
				}
			} else {
				count--;
				break;
			}
		}
		//
		while (anchorRow < rows && anchorColumn < columns) {
			if (grid[anchorRow][anchorColumn] == colorChecker) {
				count++;
				anchorRow++;
				anchorColumn++;
			} else
				break;
		}

		if (count >= 6) {
			linePresent = true;
			return linePresent;
		}
		return linePresent;
	}

	/**
	 * Given the column, row and colour to be checked, will check diagonally right being the upper part until it reaches
	 * the edge or the line is disrupted by the other colour.
	 * Notifies the computer player with all of the information gathered as well.
	 * 
	 * @param row
	 * @param column
	 * @param colorChecker
	 * @return True if line of 6 is formed
	 */
	private boolean checkDiagonalRight(int row, int column, char colorChecker) {
		int count = 0;
		int anchorRow = row;
		int anchorColumn = column;
		// Going diagonal left upwards
		while (row <= rows - 1 && column >= 0) {
			if (grid[row][column] == colorChecker) {
				count++;
				if (row < rows - 1 && column > 0) {
					row++;
					column--;
				} else {
					count--;
					break;
				}
			} else {
				count--;
				break;
			}
		}
		while (anchorRow >= 0 && anchorColumn < columns) {
			if (grid[anchorRow][anchorColumn] == colorChecker) {
				count++;
				if (anchorRow > 0) {
					anchorRow--;
					anchorColumn++;
				} else
					break;
			} else
				break;
		}

		if (count >= 6) {
			linePresent = true;
			return linePresent;
		}
		return linePresent;
	}
	// ----------------------------------------------------------------------

	/**
	 * Set True for user player to go first, and False for cpu player to go first.
	 * 
	 * @param turn
	 */
	public void setTurn(boolean turn) {
		turnClock = turn;
	}

	public boolean getTurn() {
		return turnClock;
	}

	public int getTurnCount() {
		return turnCount;
	}

	public boolean linePresent() {
		return linePresent;
	}

	public boolean matchOutcome() {
		return matchOutcome;

	}
	/**
	 * Loops through the whole grid looking for empty spaces character coded as 'G'
	 * 
	 * @return True if there is no space left to place a token
	 */
	public boolean isGridFull() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 'G') return false;
			}
		}
		return true;
	}

}
