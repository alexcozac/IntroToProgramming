package Connect6;

import java.util.ArrayList;
import java.util.Random;

public class Plankton {

	private static char[][] grid;
	static int rows;
	static int columns;
	private static Integer[] evilMind;
	private static Integer[] winMindset;
	private static int cpHighestCount, userHighestCount;
	Controller controller;
	static Random random;

	public Plankton() {
		grid = Grid.grid;
		rows = grid.length;
		columns = grid[0].length;
		evilMind = new Integer[9];
		winMindset = new Integer[9];
		cpHighestCount = 0;
		userHighestCount = 0;
		controller = new Controller();
		random = new Random();
	}

	/**
	 * Uses two Arrays to keep track of what is happening during the game, keeping
	 * track of both user incomplete lines and computer incomplete lines
	 * 
	 * @see #isEvilMindNull()
	 * @see #isWinMindsetNull()
	 * @see #highestEvilMindIndex()
	 * @see #highestWinMindsetIndex()
	 * @return int with the column that the computer player decided to place a token
	 *         in
	 */
	public static int planktonPlays() {
		int choice = random.nextInt(9);
		int evilChoice;

		if (isWinMindsetNull() == false) {
			choice = highestWinMindsetIndex();
			winMindset[choice] = null;
		}
		if (isEvilMindNull() == false) {
			evilChoice = highestEvilMindIndex();
			if (cpHighestCount < userHighestCount) {
				evilMind[evilChoice] = null;
				if (grid[0][evilChoice] != 'G') {
					evilChoice = random.nextInt(9);
				}
				return evilChoice;
			}
		}
		while (grid[0][choice] != 'G')
			choice = random.nextInt(9);

		return choice;
	}

	/**
	 * Used to populate the two arrays containing decisions to make in order to win
	 * and decisions to make in order to not lose. TODO: Computer player can not see
	 * and play diagonally, however, it may still win by accidental forming of
	 * diagonal line
	 * 
	 * @param coordinates
	 * @param direction
	 * @param color
	 * @param count
	 */
	public static void notifyPlankton(int coordinates, String direction, char color, int count) {
		int row = coordinates / 10;
		int column = coordinates % 10;

		switch (direction) {
		case "Vertical":
			if (color == 'R') {
				if ((row + count) >= 6 && row > 0) {
					winMindset[column] = count;
				}

				// Y
			} else {
				if ((row + count) >= 6 && row > 0) {
					if (count > 2) {
						evilMind[column] = count;
					}
				} else if ((row + count) < 6) {
					evilMind[column] = null;
					winMindset[column] = null;
				}
			}
			break;
		case "HorizontalLeft":
			if (color == 'R') {
				if ((column + count) >= 6 && column > 0 && row > 0) {
					if (validate(row, column - 1)) {
						winMindset[column - 1] = count;
					}
				}
				// Y
			} else {
				if ((column + count) >= 6 && column > 0 && row > 0) {
					if (validate(row, column - 1)) {
						if (count > 2) {
							evilMind[column - 1] = count;
						}
					}
				}
			}
			break;
		case "HorizontalRight":
			if (color == 'R') {
				if ((column - count + 1) <= 3 && column < columns && row > 0) {
					if (validate(row, column + 1)) {
						winMindset[column + 1] = count;
					}
				}
				// Y
			} else {
				if ((column - count + 1) <= 3 && column < columns && row > 0) {
					if (validate(row, column + 1)) {
						if (count > 2) {
							evilMind[column + 1] = count;
						}
					}
				}
			}
			break;
		case "DiagonalLeft":
			// Out of Time
			break;
		case "DiagonalRight":
			// Out of Time
			break;
		}
	}

	/**
	 * Checks if the decision is valid and coordinates can be reached within the current computer's player round.
	 * @param row
	 * @param column
	 * @return True for proper decision
	 */
	private static boolean validate(int row, int column) {
		if (row < rows - 1 && grid[row][column] == 'G') {
			if (grid[row + 1][column] == 'G')
				return false;
		} else if (grid[row][column] != 'G')
			return false;

		return true;
	}

	/**
	 * Checks if the computer player has a decision stored to try and stop the user from forming a line
	 * 
	 * @return true if user has an incomplete line
	 */
	private static boolean isEvilMindNull() {
		for (int i = 0; i < evilMind.length; i++) {
			if (evilMind[i] != null)
				return false;
		}
		return true;
	}

	/**
	 * Checks if the computer player has a decision stored to continue a line
	 * 
	 * @return
	 */
	private static boolean isWinMindsetNull() {
		for (int i = 0; i < winMindset.length; i++) {
			if (winMindset[i] != null)
				return false;
		}
		return true;
	}

	/**
	 * Checks which stored decision has the highest count of computer player's coins in a line in order to win
	 * @return
	 */
	private static int highestWinMindsetIndex() {
		int highestIndex = 0;
		int highestValue = 0;
		for (int i = 0; i < winMindset.length; i++) {
			if (winMindset[i] != null) {
				if (winMindset[i] > highestValue) {
					highestValue = winMindset[i];
					highestIndex = i;
				}
			}
		}
		cpHighestCount = highestValue;
		return highestIndex;
	}

	/**
	 * Checks which stored decision has the highest count of user player's coins in a line in order to lose if it does not take action
	 * @return
	 */
	private static int highestEvilMindIndex() {
		int highestIndex = 0;
		int highestValue = 0;
		for (int i = 0; i < evilMind.length; i++) {
			if (evilMind[i] != null) {
				if (evilMind[i] > highestValue) {
					highestValue = evilMind[i];
					highestIndex = i;
				}
			}
		}
		userHighestCount = highestValue;
		return highestIndex;
	}

}
