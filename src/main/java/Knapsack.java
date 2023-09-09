import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

    static int[][] itemList;
    static int cap;

    static int maxValue;
    static List<Integer> indexList;

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        cap = capacity;
        itemList = items;
        maxValue = 0;
        indexList = Arrays.asList(10);
        List<Integer> list = new ArrayList<>();
        getItem(items.length - 1, capacity, list);
        List<Integer> weightList = Arrays.asList(maxValue);
        List<List<Integer>> result = new ArrayList<>();
        result.add(weightList);
        result.add(indexList);
        return result;
    }

    private static int getItem(int index, int weightRemaining, List<Integer> indexes) {
        if(weightRemaining <= 0 || index < 0) {
            maxValue = cap - weightRemaining;
            indexList = indexes;
            return 0;
        }

        int weight = itemList[index][0];
        int value = itemList[index][1];

        indexes.add(index);
        int valueWithItem = value + getItem(index-1, weightRemaining - weight, indexes);

        indexes.remove(indexes.size() - 1);
        int valueWithOutItem = getItem(index - 1, weightRemaining, indexes);

        if(valueWithItem < valueWithOutItem) {
            return valueWithOutItem;
        }
        return valueWithItem;
    }

    public static void main(String[] args) {
        int profit[][] = {{ 60,10 }, { 100, 20 }, {120, 30 } };
 
        int W = 50;
 
        System.out.println(knapsackProblem(profit, W));
    }
}
