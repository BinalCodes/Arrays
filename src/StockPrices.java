
/** 
 * You are given an array of stock prices and you can buy only once and sell once, 
 * calculate the maximum profit
 * 
 * @author binal
 *
 */
public class StockPrices {

	public static void main(String[] args) {
		//int[] stockPrices = new int[]{100,200,3,56,89,19,73,12,86};
		int[] stockPrices = new int[]{1000,-2,30,6,89,9,73,-12,99};
		System.out.println("Maximum profit calculated is "+calcMaxProfit(stockPrices));

	}
	public static double calcMaxProfit(int[] stockPrices) {
		double maxP = 0.0;
		double min = stockPrices[0];
		double buyPrice = 0.0;
		double sellingPrice = 0.0;
		for(int i =0 ;i< stockPrices.length; i++) {
			if (stockPrices[i] > min) {
				if(maxP < stockPrices[i] - min) {
					maxP = stockPrices[i] - min;
					sellingPrice = stockPrices[i];
					buyPrice = min;
				}
			}
			else {
				min = stockPrices[i];
			}
		}
		System.out.println("BuyPrice = "+buyPrice +" and sell price "+sellingPrice);
		return maxP;
	}

}
