package gfg.ds.algo;

public class Stock_Buy_Sell {

    static int maximizeProfit(int price[], int start, int end) {
        if(end <= start) {
            return 0;
        }
        int ans = 0;

        for(int i=start; i<=end; i++) {
            for(int j=i+1; j<=end; j++) {
                if(price[j] > price[i]) {
                    int curr_profit = price[j]-price[i]
                            + maximizeProfit(price, start, i-1)
                            + maximizeProfit(price, j+1, end);

                    ans = Math.max(ans, curr_profit);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310,
                40, 535, 695 };
        int n = price.length;

        System.out.print(maximizeProfit(price, 0, n - 1));
    }
}
