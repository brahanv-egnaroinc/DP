package domain.algo.dp;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ContinousPartyFriends {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the total cost");
		int totalCost = Integer.parseInt(input.nextLine());
		System.out.println("enter the costs for each friend");
		String friendsCost = input.nextLine();
		input.close();
		StringTokenizer tokenizer = new StringTokenizer(friendsCost, " ");
		int costArray[] = new int[tokenizer.countTokens()];
		int index = 0;
		while (tokenizer.hasMoreTokens()) {
			costArray[index] = Integer.parseInt(tokenizer.nextToken());
			index++;
		}
		int sum = 0;
		int start = 0;
		boolean isPartyPossible = false;
		for (index = 0; index < costArray.length; index++) {
			sum += costArray[index];
			if (sum == totalCost) {
				isPartyPossible = true;
				break;
			} else if (sum > totalCost) {
				while (sum > totalCost) {
					sum -= costArray[start];
					start += 1;
					if (sum == totalCost) {
						isPartyPossible = true;
						
					}
				}
			}
			if(isPartyPossible)
				break;

		}
		if (isPartyPossible)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
