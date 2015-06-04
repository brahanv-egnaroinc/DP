package domain.algo.dp;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CoinChange {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the denominations :");
		String coin = input.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(coin, " ");
		int denomination[] = new int[tokenizer.countTokens()];
		int tokenizerCounter = 0;
		while(tokenizer.hasMoreTokens()) {
			denomination[tokenizerCounter] = Integer.parseInt(tokenizer.nextToken());
			tokenizerCounter++;
		
		}
		System.out.println("Enter the sum to be calculated");
		int sum = Integer.parseInt(input.nextLine()); 
		input.close();
		if(sum<=0) {
			System.out.println("Sum is invalid");
		}
		else {
			int[] subOptimumResults = new int[sum];
			for(int subOptimalNumber = 1; subOptimalNumber<=sum ; subOptimalNumber++) {
				int currOptimalRes = 0;
				for(int denominationIndex = 0; denominationIndex < denomination.length ; denominationIndex++) {
					if (subOptimalNumber-(denomination[denominationIndex]) == 0 ) {
						currOptimalRes = 1;
						break;
					}
					else if(!(subOptimalNumber-(denomination[denominationIndex]) < 0)) {
						if(subOptimumResults[(subOptimalNumber-denomination[denominationIndex])-1] > 0) {
							if(currOptimalRes!=0) {
								if((subOptimumResults[(subOptimalNumber-denomination[denominationIndex])-1]+1) <currOptimalRes)
									currOptimalRes = subOptimumResults[(subOptimalNumber-denomination[denominationIndex])-1]+1;
								
							}
							else
								currOptimalRes = subOptimumResults[(subOptimalNumber-denomination[denominationIndex])-1]+1;
						}
						
					}
				}
				subOptimumResults[subOptimalNumber-1] = currOptimalRes;
			}
			if(subOptimumResults[sum-1] != 0)
				System.out.println("min coins required :" +subOptimumResults[sum-1] );
			else
				System.out.println("cannot form the sum with the given coins");
		}
		
	}
}
