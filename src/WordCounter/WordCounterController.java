package WordCounter;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WordCounterController implements ActionListener {

	private JPanel panel;
	private JTextField filePath;

	private File rawTextFile;

	boolean fileChoosen = false;

	private ArrayList<String> wordList = new ArrayList<String>();
	private ArrayList<String> passedWordsList = new ArrayList<String>();
	private String[] englishStopWords;
	private List<String> englishStopWordsList;
	private TreeMap<Integer, String> wordFrequencies = new TreeMap<Integer, String>(Collections.reverseOrder());

	/**
	 * Constructor will initiate stopWordsList method
	 * 
	 * @see #stopWordsList()
	 */
	public WordCounterController() {
		stopWordsList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String name = button.getText();
		panel = (JPanel) button.getParent();
		Component[] components = panel.getComponents();

		switch (name) {
		case "Choose file":
			filePath = (JTextField) components[2];
			rawTextFile = getFile();
			if (rawTextFile != null) {
				filePath.setText(rawTextFile.getPath());
			}
			break;

		case "Count Words":
			if (fileChoosen == true) {

				try {
					FileReader reader = new FileReader(rawTextFile.getPath());
					BufferedReader bReader = new BufferedReader(reader);
					String line = null;
					while ((line = bReader.readLine()) != null) {
						if (!line.isEmpty()) {
							String[] tempLine = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
							for (int i = 0; i < tempLine.length; i++) {
								wordList.add(tempLine[i]);
							}
							System.out.println(line);
						}
					}

				} catch (Exception e1) {
				}
				displayOriginalFileWordCount();
				filterTextFile();
				countWords();
				Set keys = wordFrequencies.entrySet();
				Iterator i = keys.iterator();

				while (i.hasNext()) {
					Map.Entry currentIndex = (Map.Entry) i.next();
					AdvancedWordCounter.resultTextArea
							.append("(" + currentIndex.getKey() + ", " + currentIndex.getValue() + ")\n");
				}

			} else {
				JOptionPane.showMessageDialog(panel, "Choose a file before trying to count the words.",
						"What are you doing?", JOptionPane.WARNING_MESSAGE);
			}

			break;
		}

	}

	/**
	 * Opens a Java File Chooser and lets you select a file. Uses
	 * FileNameExtensionFilter to limit the selection availability.
	 * 
	 * @return A File containing the selected file.
	 */
	private File getFile() {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(panel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			fileChoosen = true;
			return file;
		}
		return null;

	}


	/**
	 * Populates the String type Array with words from the EnglishStopWords.txt from
	 * the /src Folder
	 * 
	 * @Warning Text file must have only 1 line
	 * 
	 * @BoundTo englishStopWordsList variable
	 * 
	 * @throws FileNotFoundException
	 */
	private void stopWordsList() {
		try {
			File file = new File("./src/WordCounter/EnglishStopWords.txt");
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			String line = null;
			while ((line = bReader.readLine()) != null) {
				englishStopWords = line.split(" ");
			}
			bReader.close();
			englishStopWordsList = Arrays.asList(englishStopWords);

		} catch (Exception e) {
		}
	}

	/**
	 * Uses a list containing Stop Words to remove all of the present words within
	 * the wordList.
	 * 
	 */
	private void filterTextFile() {
		for (int i = 0; i < wordList.size(); i++) {
			String currentWord = wordList.get(i);
			for (int j = 0; j < englishStopWords.length; j++) {
				if(currentWord.equalsIgnoreCase(englishStopWords[j])) {
					wordList.remove(i);
					i--;
					break;
				}
			}
		}
	}

	/**
	 * Counts the words present within the wordList and as it iterates it removes
	 * the already counted words
	 * 
	 */
	private void countWords() {
		while (wordList.size() > 0) {
			int count = 1;
			String word = wordList.get(0);
			wordList.remove(0);
			passedWordsList.add(word);
			for (int i = 0; i < wordList.size(); i++) {
				if (word.equalsIgnoreCase(wordList.get(i))) {
					count++;
				}
			}
			wordList.removeAll(passedWordsList);
			if (wordFrequencies.containsKey(count)) {
				wordFrequencies.put(count, wordFrequencies.get(count) + ", " + word);
			} else {
				wordFrequencies.put(count, word);
			}
		}

	}

	private void displayOriginalFileWordCount() {
		System.out.println("_______________________________");
		System.out.println("Original file word count: " + wordList.size());
	}

}
