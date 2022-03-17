package dsalgo.linkedlist;


public class Solution {
	public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int buy2 = prices[0];
        
        int profit = 0;
        int profit2 = 0;
        
        for(int price : prices) {
            buy1 = Math.min(buy1, price);
            profit = Math.max( profit, price-buy1);
            
            buy2 = Math.min(buy2, profit - price);
            profit2 = Math.max(profit2, price-buy2);
        }
        
        return profit2;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {4,5,9};
    	int[] nums2 = {4,4,8,9,9};
    	
    	Solution soln = new Solution();
    	int n = soln.maxProfit(nums2);
    	
    	System.out.println(n);
    	
	}
}