package SciCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Memory {

	private File memoryFile;
	private FileReader re;
	private BufferedReader br;
	private FileWriter wr;
	private BufferedWriter bw;
	
	/**
	 * Loads CalcMemory.txt file and opens Buffered Reader and Writer
	 * 
	 * @throws IOException
	 */
	public Memory(){
		try {
			memoryFile = new File("./src/SciCalculator/CalcMemory.txt");
			re = new FileReader(memoryFile);
			br = new BufferedReader(re);
			wr = new FileWriter(memoryFile);
			bw = new BufferedWriter(wr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Uses FileWriter and BufferedWriter to write the built expression into an external file
	 * @param input
	 * @throws IOEXception
	 */
	public void saveToFile(String input) {
		try {
			wr = new FileWriter(memoryFile);
			bw = new BufferedWriter(wr);
			bw.write(input);	
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Uses Buffered Reader to read and return the String present into the file
	 * @return String - read from the file
	 * @throws IOException
	 */
	public String getStoredFormula() {
		String storedFormula = "0";
		try {
			re = new FileReader(memoryFile);
			br = new BufferedReader(re);
			storedFormula = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return storedFormula;			
	}
	
}
