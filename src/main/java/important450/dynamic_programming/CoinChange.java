package important450.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

//also : leetcode 518
public class CoinChange {

    Map<String, Integer> map;

    public long change(int amount, int[] coins) {
        map = new HashMap<>();
        return countDP(coins, coins.length, amount);
    }

    public long countDP(int[] S, int numberOfDifferentCoins, int target ) {
        if(target == 0)
            return 1;

        if(target < 0 || numberOfDifferentCoins < 0)
            return 0;
        String key = numberOfDifferentCoins + "|" + target;

        if(!map.containsKey(key)) {
            long incl = countDP(S, numberOfDifferentCoins, target - S[numberOfDifferentCoins]);
            long excl = countDP(S, numberOfDifferentCoins - 1, target);

            map.put(key, (int) (incl + excl));
        }
        return map.get(key);
    }


    //another approach -- recursive
    public long countRecursive(int[] S, int numberOfDifferentCoins, int target) {
        if(target == 0)
            return 1;

        if(target < 0 || numberOfDifferentCoins < 0)
            return 0;

        long incl = countRecursive(S, numberOfDifferentCoins, target - S[numberOfDifferentCoins]);
        long excl = countRecursive(S,numberOfDifferentCoins - 1, target);

        return incl + excl;
    }

    public static void main(String[] args) {
        int[] S = { 1, 2, 3 };
        int target = 4;
        CoinChange c = new CoinChange();
        System.out.print("The total number of ways to get the desired change is "
                + c.countRecursive(S, S.length - 1, target));
    }
}
