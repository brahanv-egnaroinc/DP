package domain.algo.dp;

public class MaxContinuousSum {

	static int[] inputArray;
	static int[] prevSumArray;
	
	public static void main(String[] args) {
		inputArray = new int[args.length];
		
		for(int stringToIntCount = 0;stringToIntCount<args.length;stringToIntCount++) {
			inputArray[stringToIntCount] = Integer.parseInt(args[stringToIntCount]);
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
