package days;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import resources.PuzzleReader;

public class Day1 {

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		
		try {
			PuzzleReader pr = new PuzzleReader();
			input = pr.convert_to_array(new FileReader("src/resources/day1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Part One: " + part_one(input));
		System.out.println("Part Two: " + part_two(input));
	}
	
	private static String part_one(List<String> input) {
		Integer currentMax = 0;
		Integer currentElf = 0;
		
		for (String x : input) {
			if (x.equals("")) {
				if (currentElf > currentMax) {
					currentMax = currentElf;
				}
				currentElf = 0;
			} else {
				Integer currentVal = Integer.parseInt(x);
				currentElf = currentElf + currentVal;
			}
		}

		return String.valueOf(currentMax);
	}
	
	private static String part_two(List<String> input) {
		List<Integer> calorieCount = new ArrayList<Integer>();
		Integer currentElf = 0;
		
		for (String x : input) {
			if (x.equals("")) {
				calorieCount.add(currentElf);
				currentElf = 0;
			} else {
				Integer currentVal = Integer.parseInt(x);
				currentElf = currentElf + currentVal;
			}	
		}
		
		Collections.sort(calorieCount, Collections.reverseOrder()); 
		
		Integer total = calorieCount.get(0) + calorieCount.get(1) + calorieCount.get(2);
		
		return String.valueOf(total);
	}

}
