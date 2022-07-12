package Connect6;

import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;

	// StartPage
	JLayeredPane StartPage;
	JLabel StartBackground;
	JLabel StartBtn;
	static ImageIcon startBackground, startBtn, startBtnHover, startBtnClick;
	
	// Who starts Page
	JLayeredPane QuestionPage;
	JLabel QuestionBackground;
	JLabel UPBtn, CPUBtn, LoadBtn;
	static ImageIcon questionBackground, upBtn, upBtnHover, upBtnClick, cpuBtn, cpuBtnHover, cpuBtnClick, loadBtn, loadBtnHover, loadBtnClick;
	
	// Match Page
	JLayeredPane MatchPage;
	JLabel MatchBackground;
	JLabel GridFront;
	JLabel GridBack;
	JLabel FirstNr, SecondNr;
	JLabel uPlayer, cpuPlayer;
	JLabel WhoTurn;
	JLabel CoinColumn0, CoinColumn1, CoinColumn2, CoinColumn3, CoinColumn4, CoinColumn5, CoinColumn6, CoinColumn7, CoinColumn8;
	JLabel SaveBtn, ResetBtn;
	static ImageIcon matchBackground, gridFront, gridBack, nr0, nr1, nr2, nr3, nr4, nr5, nr6, nr7, nr8, nr9;
	static ImageIcon userTurn, uP, uPTurn, cpuTurn, cpuP, cpuPTurn;
	static ImageIcon yellowCoin, yellowCoinIn, redCoin, redCoinIn;
	static ImageIcon saveBtn, saveBtnHover, saveBtnClick;
	static ImageIcon resetBtn, resetBtnHover, resetBtnClick;
	
	// Match outcome Page
	JLayeredPane OutcomePage;
	JLabel OutcomeBackground;
	JLabel YesBtn, NoBtn;
	static ImageIcon outcomeBackgroundWon, outcomeBackgroundLost, outcomeBackgroundDraw;
	static ImageIcon yesBtn, yesBtnHover, yesBtnClick, noBtn, noBtnHover, noBtnClick;
	
	static File saveFile;
	
	public static void main(String[] args) {

		// TODO Temporary Console Run
//		GameLogic test = new GameLogic();
//		
//		while(true) {
//		System.out.println("012345678");
//		test.grid.printGrid();
//		
//		Scanner input = new Scanner(System.in);
//		int x = input.nextInt();
//		test.controller.placeToken(x);
//		
//		}
		GUI page = new GUI();
		page.setVisible(true);

	}

	public GUI() {
		//Start Page Images
		startBackground = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/StartPage.png"));
		startBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/StartBtn.png"));
		startBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/StartBtnHover.png"));
		startBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/StartBtnClick.png"));

		//Who Starts Page Images
		questionBackground = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/WhoStarts.png"));
		upBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/UserPlayerBtn.png"));
		upBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/UserPlayerBtnHover.png"));
		upBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/UserPlayerBtnClick.png"));
		cpuBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/CPUPlayerBtn.png"));
		cpuBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/CPUPlayerBtnHover.png"));
		cpuBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/CPUPlayerBtnClick.png"));
		loadBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/LoadBtn.png"));
		loadBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/LoadBtnHover.png"));
		loadBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/LoadBtnClick.png"));
		
		//Match Page Images
		matchBackground = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/MatchBackground.png"));
		gridFront = new ImageIcon(this.getClass().getResource("/Connect6/Elements/GridFront.png"));
		gridBack = new ImageIcon(this.getClass().getResource("/Connect6/Elements/GridBack.png"));
		nr0 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr0.png"));
		nr1 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr1.png"));
		nr2 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr2.png"));
		nr3 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr3.png"));
		nr4 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr4.png"));
		nr5 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr5.png"));
		nr6 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr6.png"));
		nr7 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr7.png"));
		nr8 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr8.png"));
		nr9 = new ImageIcon(this.getClass().getResource("/Connect6/Elements/Nr9.png"));
		userTurn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/UserTurn.png"));
		cpuTurn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/CPUTurn.png"));
		uP = new ImageIcon(this.getClass().getResource("/Connect6/Elements/UPlayer.png"));
		uPTurn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/UPlayerTurn.png"));
		cpuP = new ImageIcon(this.getClass().getResource("/Connect6/Elements/CPUPlayer.png"));
		cpuPTurn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/CPUPlayerTurn.png"));
		yellowCoin = new ImageIcon(this.getClass().getResource("/Connect6/Elements/YellowCoin.png"));
		yellowCoinIn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/YellowCoinIn.png"));
		redCoin = new ImageIcon(this.getClass().getResource("/Connect6/Elements/RedCoin.png"));
		redCoinIn = new ImageIcon(this.getClass().getResource("/Connect6/Elements/RedCoinIn.png"));
		saveBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/SaveBtn.png"));
		saveBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/SaveBtnHover.png"));
		saveBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/SaveBtnClick.png"));
		resetBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/ResetBtn.png"));
		resetBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/ResetBtnHover.png"));
		resetBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/ResetBtnClick.png"));

		//Outcome Page Images
		outcomeBackgroundWon = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/YouWon.png"));
		outcomeBackgroundLost = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/YouLost.png"));
		outcomeBackgroundDraw = new ImageIcon(this.getClass().getResource("/Connect6/Backgrounds/Draw.png"));
		yesBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/YesBtn.png"));
		yesBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/YesBtnHover.png"));
		yesBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/YesBtnClick.png"));
		noBtn = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/NoBtn.png"));
		noBtnHover = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/NoBtnHover.png"));
		noBtnClick = new ImageIcon(this.getClass().getResource("/Connect6/Buttons/NoBtnClick.png"));

		saveFile = new File("./src/Connect6/SavedGame.txt");
		
		GUIController controller = new GUIController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//To get the workspace to 1024x768 an extra 16px width and 39px height were added
		setBounds(0, 0, 1040, 807);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TODO: Start Page Components
		StartPage = new JLayeredPane();
		StartPage.setBounds(0, 0, 1024, 768);
		contentPane.add(StartPage);
		
		StartBtn = new JLabel("StartBtn");
		StartBtn.setBounds(435, 500, 154, 54);
		StartBtn.setIcon(startBtn);
		StartBtn.addMouseListener(controller);
		StartPage.add(StartBtn);
		
		StartBackground = new JLabel("StartBackground");
		StartBackground.setBounds(0, 0, 1024, 768);
		StartBackground.setIcon(startBackground);
		StartPage.add(StartBackground);
		
		
		//TODO: Who Starts Page Components
		QuestionPage = new JLayeredPane();
		QuestionPage.setBounds(0, 0, 1024, 768);
		QuestionPage.setVisible(false);
		contentPane.add(QuestionPage);
		
		UPBtn = new JLabel("UPBtn");
		UPBtn.setBounds(140, 425, 154, 54);
		UPBtn.setIcon(upBtn);
		UPBtn.addMouseListener(controller);
		QuestionPage.add(UPBtn);
		
		CPUBtn = new JLabel("CPUBtn");
		CPUBtn.setBounds(434, 425, 154, 54);
		CPUBtn.setIcon(cpuBtn);
		CPUBtn.addMouseListener(controller);
		QuestionPage.add(CPUBtn);
		
		LoadBtn = new JLabel("LoadBtn");
		LoadBtn.setBounds(728, 425, 154, 54);
		LoadBtn.setIcon(loadBtn);
		LoadBtn.addMouseListener(controller);
		QuestionPage.add(LoadBtn);
		
		QuestionBackground = new JLabel();
		QuestionBackground.setBounds(0, 0, 1024, 768);
		QuestionBackground.setIcon(questionBackground);
		QuestionPage.add(QuestionBackground);
		
		//TODO: Match Page Components
		MatchPage = new JLayeredPane();
		MatchPage.setBounds(0, 0, 1024, 768);
		MatchPage.setVisible(false);
		contentPane.add(MatchPage);
		
		CoinColumn0 = new JLabel();
		CoinColumn0.setName("c0");
		CoinColumn0.setBounds(197, 110, 70, 70);
		CoinColumn0.addMouseListener(controller);
		MatchPage.add(CoinColumn0);
		
		CoinColumn1 = new JLabel();
		CoinColumn1.setName("c1");
		CoinColumn1.setBounds(267, 110, 70, 70);
		CoinColumn1.addMouseListener(controller);
		MatchPage.add(CoinColumn1);
		
		CoinColumn2 = new JLabel();
		CoinColumn2.setName("c2");
		CoinColumn2.setBounds(337, 110, 70, 70);
		CoinColumn2.addMouseListener(controller);
		MatchPage.add(CoinColumn2);
		
		CoinColumn3 = new JLabel();
		CoinColumn3.setName("c3");
		CoinColumn3.setBounds(407, 110, 70, 70);
		CoinColumn3.addMouseListener(controller);
		MatchPage.add(CoinColumn3);
		
		CoinColumn4 = new JLabel();
		CoinColumn4.setName("c4");
		CoinColumn4.setBounds(477, 110, 70, 70);
		CoinColumn4.addMouseListener(controller);
		MatchPage.add(CoinColumn4);
		
		CoinColumn5 = new JLabel();
		CoinColumn5.setName("c5");
		CoinColumn5.setBounds(547, 110, 70, 70);
		CoinColumn5.addMouseListener(controller);
		MatchPage.add(CoinColumn5);
		
		CoinColumn6 = new JLabel();
		CoinColumn6.setName("c6");
		CoinColumn6.setBounds(617, 110, 70, 70);
		CoinColumn6.addMouseListener(controller);
		MatchPage.add(CoinColumn6);
		
		CoinColumn7 = new JLabel();
		CoinColumn7.setName("c7");
		CoinColumn7.setBounds(687, 110, 70, 70);
		CoinColumn7.addMouseListener(controller);
		MatchPage.add(CoinColumn7);
		
		CoinColumn8 = new JLabel();
		CoinColumn8.setName("c8");
		CoinColumn8.setBounds(757, 110, 70, 70);
		CoinColumn8.addMouseListener(controller);
		MatchPage.add(CoinColumn8);
		//Component 9
		uPlayer = new JLabel("uPlayer");
		uPlayer.setBounds(810, 15, 74, 74);
		uPlayer.setIcon(uP);
		MatchPage.add(uPlayer);
		//Component 10
		cpuPlayer = new JLabel("cpuPlayer");
		cpuPlayer.setBounds(920, 15, 74, 74);
		cpuPlayer.setIcon(cpuP);
		MatchPage.add(cpuPlayer);

		ResetBtn = new JLabel("ResetBtn");
		ResetBtn.setBounds(845, 686, 154, 54);
		ResetBtn.setIcon(resetBtn);
		ResetBtn.addMouseListener(controller);
		MatchPage.add(ResetBtn);
		
		SaveBtn = new JLabel("SaveBtn");
		SaveBtn.setBounds(25, 686, 154, 54);
		SaveBtn.setIcon(saveBtn);
		SaveBtn.addMouseListener(controller);
		MatchPage.add(SaveBtn);
		
		//Component 13
		WhoTurn = new JLabel();
		WhoTurn.setBounds(342, 32, 340, 40);
		MatchPage.add(WhoTurn);
		//Component 14	
		FirstNr = new JLabel("FirstNr");
		FirstNr.setIcon(nr0);
		FirstNr.setBounds(170, 32, 30, 40);
		MatchPage.add(FirstNr);
		//Component 15
		SecondNr = new JLabel("SecondNr");
		SecondNr.setIcon(nr0);
		SecondNr.setBounds(200, 32, 30, 40);
		MatchPage.add(SecondNr);
		
		GridFront = new JLabel("GridFront");
		GridFront.setIcon(gridFront);
		GridFront.setBounds(197, 180, 630, 560);
		MatchPage.add(GridFront);
		
		GridBack = new JLabel("GridBack");
		GridBack.setIcon(gridBack);
		GridBack.setBounds(197, 180, 630, 560);
		MatchPage.add(GridBack);
		//Component 18
		MatchBackground = new JLabel();
		MatchBackground.setBounds(0, 0, 1024, 768);
		MatchBackground.setIcon(matchBackground);
		MatchPage.add(MatchBackground);
		
		//TODO: Outcome Page Components
		OutcomePage = new JLayeredPane();
		OutcomePage.setBounds(0, 0, 1024, 768);
		OutcomePage.setVisible(false);
		contentPane.add(OutcomePage);
		
		YesBtn = new JLabel("YesBtn");
		YesBtn.setBounds(300, 425, 154, 54);
		YesBtn.setIcon(yesBtn);
		YesBtn.addMouseListener(controller);
		OutcomePage.add(YesBtn);
		
		NoBtn = new JLabel("NoBtn");
		NoBtn.setBounds(570, 425, 154, 54);
		NoBtn.setIcon(noBtn);
		NoBtn.addMouseListener(controller);
		OutcomePage.add(NoBtn);
		
		OutcomeBackground = new JLabel("OutcomeBackground");
		OutcomeBackground.setBounds(0, 0, 1024, 768);
		OutcomePage.add(OutcomeBackground);
		
		
		
	}

}
