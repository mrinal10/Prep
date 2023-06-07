package sixty.days.dsa.day2;

public class BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxTillNow = 0;
        for(int i = prices.length-1; i >= 0; i--){
            if(maxTillNow < prices[i]) {
                maxTillNow = prices[i];
            } else {
                if(profit < (maxTillNow - prices[i])) {
                    profit = maxTillNow - prices[i];
                }
            }
        }
        return profit;
    }
}
