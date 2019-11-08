package com.stackroute;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class LongestSpan {

	private static Scanner scan;

	// Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int inputCount = scan.nextInt();
		int[] input = new int[inputCount];

		for(int i=0;i<inputCount;i++) {
			input[i] = scan.nextInt();
		}
		

		String longestSpan = findLongestSpan(input);
		
		System.out.println(longestSpan);

	}

	public static String findLongestSpan(int[] numbers) {

		if (numbers.length > 0 && numbers != null) {
			HashMap<Integer, int[]> checkSpan = new HashMap<>();

			for (int i = 0; i < numbers.length; i++) {
				if (checkSpan.containsKey(numbers[i])) {

					int index=checkSpan.get(numbers[i])[0];
					checkSpan.put(numbers[i], new int[] {index,i+1-index});
				} else {
					checkSpan.put(numbers[i], new int[] { i, 1 });
				}
			}

			int maxCount=0;
			int maxInt=0;
			
			for (Map.Entry<Integer, int[]> i : checkSpan.entrySet()) {
				if(maxCount==0||i.getValue()[1]>maxCount) {
					maxCount=i.getValue()[1];
					maxInt=i.getKey();
				}
				else if(i.getValue()[1]==maxCount) {
					if(i.getKey()>maxInt) {
						maxInt=i.getKey();
					}
				}
			
			}
			String longestSpan=maxInt+":"+maxCount;
			return longestSpan;
		}
		return "Empty Array";
	}
}
