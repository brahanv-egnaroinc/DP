package domain.algo.dp;

import java.util.Scanner;
import java.util.StringTokenizer;


public class StockMarket {

	public static void main(String[] args) {
		
		Scanner input =  new Scanner(System.in);
		System.out.println("Enter the input ");
		String count = input.nextLine();
		input.close();
		StringTokenizer inputData = new StringTokenizer(count, " ");
        int stock[] = new int[inputData.countTokens()];
        int tokenizerCounter = 0;
		while(inputData.hasMoreTokens()) {
			stock[tokenizerCounter] = Integer.parseInt(inputData.nextToken());
			tokenizerCounter++;
		}
		
		int maxProfit = stock[1]-stock[0];
		
		int startingStock = stock[0];
		for(int i =2;i<stock.length;i++) {
			if(stock[i]<startingStock) {
				startingStock = stock[i];
				continue;
			}
			int currentProfit = stock[i]-startingStock;
			if(maxProfit<currentProfit) {
				
				maxProfit=currentProfit;
			}
		}
		System.out.println(maxProfit);
	
	}

}