package domain.algo.dp;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxContinuousSum {

	static int[] inputArray;
	static int[] prevSumArray;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array of integers");
		String input = scanner.nextLine();
		scanner.close();
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		inputArray = new int[tokenizer.countTokens()];
		int inputArrayindex = 0;
		while(tokenizer.hasMoreTokens()) {
			inputArray[inputArrayindex] = Integer.parseInt(tokenizer.nextToken());
			inputArrayindex++;
		}
		
		int maxSum = inputArray[0];
		int[] maxSumPos = new int[2];
		prevSumArray = inputArray.clone();
		
		for(int numberOfPos = 0;numberOfPos<inputArray.length;numberOfPos++) {
			for(int arrayIndex = 0 ; arrayIndex<inputArray.length;arrayIndex++) {
				if(inputArray[arrayIndex]<=0 || (arrayIndex+numberOfPos)>= inputArray.length) {
					continue;
				}
				
					int result = calculateSum(arrayIndex,numberOfPos);
					prevSumArray[arrayIndex] = result;
					if (result > maxSum) {
						maxSum = result;
						maxSumPos[0] = arrayIndex;
						maxSumPos[1] = numberOfPos;
				
				}
			}
		}
		
		System.out.println("Maximum Sum is "+maxSum);
		System.out.println("Maximum sum's positions : "+maxSumPos[0]+"\t"+maxSumPos[1]);

	}

	private static int calculateSum(int arrayIndex, int numberOfPos) {
		if(numberOfPos==0) 
			return inputArray[arrayIndex];
		
		return prevSumArray[arrayIndex]+inputArray[arrayIndex+numberOfPos];
	}

}
