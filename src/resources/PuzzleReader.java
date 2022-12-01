package resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PuzzleReader {

	public List<String> convert_to_array(FileReader fr) {
		
		List<String> puzzle_input = new ArrayList<String>();
		
		try {
			BufferedReader bf = new BufferedReader(fr);	
			String line = bf.readLine();
			
			while (line != null) {
				puzzle_input.add(line);
				line = bf.readLine();
			}
			
			bf.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return puzzle_input;	
	}	
}
