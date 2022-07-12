package WordCounter;
import java.awt.Font;
import javax.swing.*;

public class AdvancedWordCounter extends JFrame {
	
	JPanel panel;
	JLabel title;
	JButton choosefileBtn;
	JTextField fileLocation;
	static JTextArea resultTextArea;
	JButton countBtn;
	JScrollPane scrollPane;
	JFileChooser fileChooser;
	
	public static void main(String[] args) {
		
		AdvancedWordCounter page = new AdvancedWordCounter();
		page.setVisible(true);
		
	}
	
	public AdvancedWordCounter() {
		panel = new JPanel();
		title = new JLabel();
		choosefileBtn = new JButton();
		fileLocation = new JTextField();
		resultTextArea = new JTextArea();
		scrollPane = new JScrollPane(resultTextArea);
		countBtn = new JButton();
		fileChooser = new JFileChooser();
		
		WordCounterController controller = new WordCounterController();
		
		//Frame initialisation
		setBounds(0, 0, 600, 450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		panel.setLayout(null);
		
		title.setBounds(120, 50, 340, 40);
		title.setText("Advanced Word Counter");
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(title);
		
		choosefileBtn.setBounds(35, 120, 100, 30);
		choosefileBtn.setText("Choose file");
		choosefileBtn.addActionListener(controller);
		panel.add(choosefileBtn);
		
		fileLocation.setBounds(145, 120, 400, 30);
		fileLocation.setName("filelocation");
		fileLocation.setEditable(false);
		panel.add(fileLocation);
		
		countBtn.setBounds(235, 175, 110, 30);
		countBtn.setText("Count Words");
		countBtn.addActionListener(controller);
		panel.add(countBtn);
		
		scrollPane.setBounds(65, 230, 450, 150);
		panel.add(scrollPane);
		resultTextArea.setEditable(false);

		
	}		
	
	

}
