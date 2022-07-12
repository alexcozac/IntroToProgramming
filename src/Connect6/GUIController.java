package Connect6;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class GUIController implements MouseListener {

	private JPanel panel;
	private ArrayList<Component> buttonsForCP = new ArrayList<Component>();
	private ArrayList<Integer> savedGameArray = new ArrayList<Integer>();
	private String whoStartsForSave;
	private ArrayList<Integer> toBeSavedArray = new ArrayList<Integer>();
	GameLogic gameLogic = new GameLogic();
	Robot robot;
	boolean loadInProgress = false;
	int loadIterator = 0;

	@Override
	public void mousePressed(MouseEvent e) {

		// TODO MousePressed Event
		JLabel button = (JLabel) e.getSource();
		String name = button.getText();
		JLayeredPane parent = (JLayeredPane) button.getParent();
		JPanel pane = (JPanel) parent.getParent();
		Component[] components = pane.getComponents();
		Integer layerDepth = 1;

		// Used to get the names of the columns when the match is ongoing
		if (button.getName() != null) {
			name = button.getName();
			loadIterator++;
			if (loadIterator == savedGameArray.size()) {
				loadInProgress = false;
			}
		}

		switch (name) {
		case "StartBtn":
			button.setIcon(GUI.startBtnClick);
			break;
		case "UPBtn":
			button.setIcon(GUI.upBtnClick);
			break;
		case "CPUBtn":
			button.setIcon(GUI.cpuBtnClick);
			break;
		case "LoadBtn":
			button.setIcon(GUI.loadBtnClick);
			// Loading save file
			try {
				FileReader reader = new FileReader(GUI.saveFile);
				BufferedReader bReader = new BufferedReader(reader);
				String line = null;
				boolean whoStartsSet = false;
				while ((line = bReader.readLine()) != null) {
					if (line.equalsIgnoreCase("true") && whoStartsSet == false) {
						gameLogic.controller.setTurn(true);
						whoStartsForSave = "true";
					} else if (line.equalsIgnoreCase("false") && whoStartsSet == false) {
						gameLogic.controller.setTurn(false);
						whoStartsForSave = "false";
					}
					if (whoStartsSet) {
						String[] stringColumns = line.split(" ");
						for (int i = 0; i < stringColumns.length; i++) {
							savedGameArray.add(Integer.parseInt(stringColumns[i]));
						}
					}
					whoStartsSet = true;
				}
			} catch (Exception e2) {
			}
			// Changes the page
			JLayeredPane currentPage, nextPage;
			currentPage = (JLayeredPane) components[1];
			nextPage = (JLayeredPane) components[2];
			for (int i = 0; i < 9; i++) {
				buttonsForCP.add(nextPage.getComponent(i));
			}
			currentPage.setVisible(false);
			nextPage.setVisible(true);
			loadInProgress = true;
			reconstructGameBoard(panel);
			break;
		// Match Page
		case "SaveBtn":
			button.setIcon(GUI.saveBtnClick);
			try {
				FileWriter writer = new FileWriter(GUI.saveFile);
				writer.write(whoStartsForSave + "\n");
				String fullLine = "";
				for (int i = 0; i < toBeSavedArray.size(); i++) {
					fullLine += toBeSavedArray.get(i).toString() + " ";
				}
				writer.write(fullLine);
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "ResetBtn":
			button.setIcon(GUI.resetBtnClick);
			break;
		case "YesBtn":
			button.setIcon(GUI.yesBtnClick);
			break;
		case "NoBtn":
			button.setIcon(GUI.noBtnClick);
			break;
		case "c0":
			tokenPlacement(button, parent, 0, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(0);
			break;
		case "c1":
			tokenPlacement(button, parent, 1, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(1);
			break;
		case "c2":
			tokenPlacement(button, parent, 2, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(2);
			break;
		case "c3":
			tokenPlacement(button, parent, 3, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(3);
			break;
		case "c4":
			tokenPlacement(button, parent, 4, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(4);
			break;
		case "c5":
			tokenPlacement(button, parent, 5, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(5);
			break;
		case "c6":
			tokenPlacement(button, parent, 6, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(6);
			break;
		case "c7":
			tokenPlacement(button, parent, 7, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(7);
			break;
		case "c8":
			tokenPlacement(button, parent, 8, layerDepth);
			updateCountDisplayed(parent);
			showWhoPlays(parent);
			endGame(parent);
			toBeSavedArray.add(8);
			break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO MouseReleased Event
		JLabel button = (JLabel) e.getSource();
		String name = button.getText();
		JLayeredPane parent = (JLayeredPane) button.getParent();
		panel = (JPanel) parent.getParent();
		Component[] components = panel.getComponents();
		JLayeredPane currentPage, nextPage;

		// Used to get the names of the columns when the match is ongoing
		if (button.getName() != null)
			name = button.getName();

		switch (name) {
		// Start Page
		case "StartBtn":
			button.setIcon(GUI.startBtnHover);
			currentPage = (JLayeredPane) components[0];
			nextPage = (JLayeredPane) components[1];
			currentPage.setVisible(false);
			nextPage.setVisible(true);
			break;
		// Who Starts Page
		case "UPBtn":
			button.setIcon(GUI.upBtnHover);
			currentPage = (JLayeredPane) components[1];
			nextPage = (JLayeredPane) components[2];

			JLabel userturn = (JLabel) nextPage.getComponent(13);
			userturn.setIcon(GUI.userTurn);
			whoStartsForSave = "true";
			gameLogic.controller.setTurn(true);

			for (int i = 0; i < 9; i++) {
				buttonsForCP.add(nextPage.getComponent(i));
			}

			showWhoPlays(nextPage);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
			break;
		case "CPUBtn":
			button.setIcon(GUI.cpuBtnHover);
			currentPage = (JLayeredPane) components[1];
			nextPage = (JLayeredPane) components[2];

			JLabel cputurn = (JLabel) nextPage.getComponent(13);
			cputurn.setIcon(GUI.cpuTurn);
			whoStartsForSave = "false";
			gameLogic.controller.setTurn(false);

			for (int i = 0; i < 9; i++) {
				buttonsForCP.add(nextPage.getComponent(i));
			}

			showWhoPlays(nextPage);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
			if (gameLogic.controller.getTurn() == false) {
				cpInteraction(panel);
			}
			break;
		case "LoadBtn":
			button.setIcon(GUI.loadBtnHover);
			break;
		// Match Page
		case "SaveBtn":
			button.setIcon(GUI.saveBtnHover);
			break;
		case "ResetBtn":
			button.setIcon(GUI.resetBtnHover);
			resetMatch(parent);
			updateCountDisplayed(parent);
			break;
		case "YesBtn":
			button.setIcon(GUI.yesBtnHover);
			currentPage = (JLayeredPane) components[3];
			nextPage = (JLayeredPane) components[1];
			resetMatch((JLayeredPane) components[2]);
			updateCountDisplayed((JLayeredPane) components[2]);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
			break;
		case "NoBtn":
			button.setIcon(GUI.noBtnHover);
			System.exit(0);
			break;
		case "c0":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c1":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c2":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c3":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c4":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c5":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c6":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c7":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		case "c8":
			if (gameLogic.controller.getTurn() == false && loadInProgress == false) {
				cpInteraction(panel);
			}
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO MouseEntered Event
		JLabel button = (JLabel) e.getSource();
		String name = button.getText();

		// Used to get the names of the columns when the match is ongoing
		if (button.getName() != null)
			name = button.getName();

		switch (name) {
		case "StartBtn":
			button.setIcon(GUI.startBtnHover);
			break;
		case "UPBtn":
			button.setIcon(GUI.upBtnHover);
			break;
		case "CPUBtn":
			button.setIcon(GUI.cpuBtnHover);
			break;
		case "LoadBtn":
			button.setIcon(GUI.loadBtnHover);
			break;
		// Match Page
		case "SaveBtn":
			button.setIcon(GUI.saveBtnHover);
			break;
		case "ResetBtn":
			button.setIcon(GUI.resetBtnHover);
			break;
		case "YesBtn":
			button.setIcon(GUI.yesBtnHover);
			break;
		case "NoBtn":
			button.setIcon(GUI.noBtnHover);
			break;
		case "c0":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c1":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c2":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c3":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c4":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c5":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c6":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c7":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		case "c8":
			if (gameLogic.controller.getTurn())
				button.setIcon(GUI.yellowCoin);
			else
				button.setIcon(GUI.redCoin);
			break;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO MouseExited Event
		JLabel button = (JLabel) e.getSource();
		String name = button.getText();

		// Used to get the names of the columns when the match is ongoing
		if (button.getName() != null)
			name = button.getName();
		switch (name) {
		case "StartBtn":
			button.setIcon(GUI.startBtn);
			break;
		case "UPBtn":
			button.setIcon(GUI.upBtn);
			break;
		case "CPUBtn":
			button.setIcon(GUI.cpuBtn);
			break;
		case "LoadBtn":
			button.setIcon(GUI.loadBtn);
			break;
		// Match Page
		case "SaveBtn":
			button.setIcon(GUI.saveBtn);
			break;
		case "ResetBtn":
			button.setIcon(GUI.resetBtn);
			break;
		case "YesBtn":
			button.setIcon(GUI.yesBtn);
			break;
		case "NoBtn":
			button.setIcon(GUI.noBtn);
			break;
		case "c0":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c1":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c2":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c3":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c4":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c5":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c6":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c7":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		case "c8":
			if (gameLogic.controller.getTurn())
				button.setIcon(null);
			else
				button.setIcon(null);
			break;
		}
	}

	/**
	 * Only used in Mouse Pressed event.
	 * 
	 * @param button - Button that is pressed
	 * @param parent - Parent of the pressed button
	 * @param column - Between 0 and 8 which is used by @see
	 *               #Controller.placeToken()
	 * @param depth  - Used to separate from the rest of the components
	 */
	public void tokenPlacement(JLabel button, JLayeredPane parent, int column, Integer depth) {
		if (gameLogic.controller.getTurn()) {
			button.setIcon(null);
			int index = gameLogic.controller.placeToken(column);
			int top = button.getY() + button.getHeight();
			for (int i = 0; i < index; i++) {
				top += button.getHeight();
			}
			JLabel token = new JLabel();
			token.setBounds(button.getX(), top, button.getWidth(), button.getHeight());
			token.setIcon(GUI.yellowCoinIn);
			parent.add(token, depth);
		} else {
			button.setIcon(null);
			int index = gameLogic.controller.placeToken(column);
			int top = button.getY() + button.getHeight();
			for (int i = 0; i < index; i++) {
				top += button.getHeight();
			}
			JLabel token = new JLabel();
			token.setBounds(button.getX(), top, button.getWidth(), button.getHeight());
			token.setIcon(GUI.redCoinIn);
			parent.add(token, depth);
		}
	}

	public void showWhoPlays(JLayeredPane currentPage) {
		JLabel uPlayer = (JLabel) currentPage.getComponentAt(810, 15);
		JLabel cpuPlayer = (JLabel) currentPage.getComponentAt(920, 15);
		JLabel whoTurn = (JLabel) currentPage.getComponentAt(342, 32);
		if (gameLogic.controller.getTurn()) {
			uPlayer.setIcon(GUI.uPTurn);
			whoTurn.setIcon(GUI.userTurn);
			cpuPlayer.setIcon(GUI.cpuP);
		} else {
			uPlayer.setIcon(GUI.uP);
			whoTurn.setIcon(GUI.cpuTurn);
			cpuPlayer.setIcon(GUI.cpuPTurn);
		}
	}

	public void updateCountDisplayed(JLayeredPane currentPage) {
		JLabel firstNr = (JLabel) currentPage.getComponentAt(170, 32);
		JLabel secondNr = (JLabel) currentPage.getComponentAt(200, 32);
		int count = gameLogic.controller.getTurnCount();
		int first = count / 10;
		int second = count % 10;

		switch (second) {
		case 0:
			secondNr.setIcon(GUI.nr0);
			break;
		case 1:
			secondNr.setIcon(GUI.nr1);
			break;
		case 2:
			secondNr.setIcon(GUI.nr2);
			break;
		case 3:
			secondNr.setIcon(GUI.nr3);
			break;
		case 4:
			secondNr.setIcon(GUI.nr4);
			break;
		case 5:
			secondNr.setIcon(GUI.nr5);
			break;
		case 6:
			secondNr.setIcon(GUI.nr6);
			break;
		case 7:
			secondNr.setIcon(GUI.nr7);
			break;
		case 8:
			secondNr.setIcon(GUI.nr8);
			break;
		case 9:
			secondNr.setIcon(GUI.nr9);
			break;

		}

		switch (first) {
		case 0:
			firstNr.setIcon(GUI.nr0);
			break;
		case 1:
			firstNr.setIcon(GUI.nr1);
			break;
		case 2:
			firstNr.setIcon(GUI.nr2);
			break;
		case 3:
			firstNr.setIcon(GUI.nr3);
			break;
		case 4:
			firstNr.setIcon(GUI.nr4);
			break;
		case 5:
			firstNr.setIcon(GUI.nr5);
			break;
		case 6:
			firstNr.setIcon(GUI.nr6);
			break;
		case 7:
			firstNr.setIcon(GUI.nr7);
			break;
		case 8:
			firstNr.setIcon(GUI.nr8);
			break;
		case 9:
			firstNr.setIcon(GUI.nr9);
			break;

		}

	}

	public void endGame(JLayeredPane parent) {

		if (gameLogic.controller.matchOutcome() == true && gameLogic.controller.linePresent == true) {
			panel = (JPanel) parent.getParent();
			Component[] components = panel.getComponents();
			JLayeredPane currentPage, nextPage;
			currentPage = (JLayeredPane) components[2];
			nextPage = (JLayeredPane) components[3];
			JLabel outcomeBackground = (JLabel) nextPage.getComponent(2);
			outcomeBackground.setIcon(GUI.outcomeBackgroundWon);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
		} else if (gameLogic.controller.matchOutcome() == false && gameLogic.controller.linePresent == true) {
			panel = (JPanel) parent.getParent();
			Component[] components = panel.getComponents();
			JLayeredPane currentPage, nextPage;
			currentPage = (JLayeredPane) components[2];
			nextPage = (JLayeredPane) components[3];
			JLabel outcomeBackground = (JLabel) nextPage.getComponent(2);
			outcomeBackground.setIcon(GUI.outcomeBackgroundLost);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
		} else if (gameLogic.controller.isGridFull()) {
			panel = (JPanel) parent.getParent();
			Component[] components = panel.getComponents();
			JLayeredPane currentPage, nextPage;
			currentPage = (JLayeredPane) components[2];
			nextPage = (JLayeredPane) components[3];
			JLabel outcomeBackground = (JLabel) nextPage.getComponent(2);
			outcomeBackground.setIcon(GUI.outcomeBackgroundDraw);
			currentPage.setVisible(false);
			nextPage.setVisible(true);
		}
	}

	public void resetMatch(JLayeredPane parent) {
		Component[] components = parent.getComponentsInLayer(1);
		for (int i = 0; i < components.length; i++) {
			JLabel toRemove = (JLabel) components[i];
			toRemove.setVisible(false);
			parent.remove(toRemove);
		}
		gameLogic = new GameLogic();
		savedGameArray = new ArrayList<Integer>();
		toBeSavedArray = new ArrayList<Integer>();
	}

	/** Uses the robot to interact with the GUI based on planktonPlats() output.
	 * 
	 * @see #gameLogic.plankton.planktonPlays()
	 * @param pane used to get X and Y coordinates of the window within the users screen.
	 */
	public void cpInteraction(JPanel pane) {
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(750);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel choice = (JLabel) buttonsForCP.get(gameLogic.plankton.planktonPlays());
		Point window = pane.getLocationOnScreen();
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		robot.mouseMove(window.x + choice.getX() + 35, window.y + choice.getY() + 35);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseMove(mouse.x, mouse.y);
	}
	/** Uses the robot to simulate the game up until the moves stored within the save file end.
	 * 
	 * @BoundTo savedGameArray ArrayList
	 * 
	 * @param pane used to get X and Y coordinates of the window within the users screen. 
	 * 
	 * @throws AWTException
	 */
	public void reconstructGameBoard(JPanel pane) {
		Point window = pane.getLocationOnScreen();
		try {
			robot = new Robot();
		} catch (AWTException e1) {
		}
		for (int i = 0; i < savedGameArray.size(); i++) {
			JLabel choice = (JLabel) buttonsForCP.get(savedGameArray.get(i));
			robot.mouseMove(window.x + choice.getX() + 35, window.y + choice.getY() + 35);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
}
