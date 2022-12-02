package days;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import resources.PuzzleReader;

public class Day2 {

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		
		try {
			PuzzleReader pr = new PuzzleReader();
			input = pr.convert_to_array(new FileReader("src/resources/day2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Part One: " + part_one(input));
		System.out.println("Part Two: " + part_two(input));
	}
	
	private static String part_one(List<String> input) {
		Integer totalScore = 0;

		for (String x : input) {
			String[] choices = x.split(" ");
			
			String opponent = choices[0];
			String response = convert_shape(choices[1]);
			
			totalScore = totalScore + get_match_result(opponent, response) + get_shape_score(response);
		}

		return String.valueOf(totalScore);
	}
	
	private static String part_two(List<String> input) {
		Integer totalScore = 0;

		for (String x : input) {
			String[] choices = x.split(" ");
			
			String opponent = choices[0];
			String result = calculate_round_end(choices[0], convert_shape(choices[1]));
			
			totalScore = totalScore + get_match_result(opponent, result) + get_shape_score(result);
		}

		return String.valueOf(totalScore);
	}
	
	private static String calculate_round_end(String shape, String result) {
		if (result.equals("A")) {
			if (shape.equals("A")) {
				return "C";
			} else if (shape.equals("B")) {
				return "A";
			} else if (shape.equals("C")) {
				return "B";
			}
		} else if (result.equals("B")) {
			return shape;
		} else if (result.equals("C")) {
			if (shape.equals("A")) {
				return "B";
			} else if (shape.equals("B")) {
				return "C";
			} else if (shape.equals("C")) {
				return "A";
			}
		}
		return result;
	}
	
	private static String convert_shape(String shape) {
		if (shape.equals("X")) {
			return "A";
		} else if (shape.equals("Y")) {
			return "B";
		} else if (shape.equals("Z")) {
			return "C";
		}
		return null;
	}
	private static int get_match_result(String opp, String res) {
		if (opp.equals(res)) {
			return 3;
		} else if (opp.equals("A") && res.equals("B") || opp.equals("B") && res.equals("C") || opp.equals("C") && res.equals("A")) {
			return 6;
		} else {
			return 0;
		}
	}

	private static Integer get_shape_score(String shape) {
		if (shape.equals("A")) {
			return 1;
		} else if (shape.equals("B")) {
			return 2;
		} else if (shape.equals("C")) {
			return 3;
		} 
		return 0;
	}
	
}
