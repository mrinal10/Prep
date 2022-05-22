package amazon;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList();
        recursiveHelper(0, target, 0, candidates, new ArrayList<>());
        return result;
    }

    private void recursiveHelper(int combinationSum, int target, int index, int[] candidateSet, List<Integer> pathTillNow) {

        if(combinationSum > target) {
            return;
        }

        if(combinationSum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(pathTillNow);
            result.add(temp);
            return;
        }

        for (int i = index; i < candidateSet.length; i++) {

            pathTillNow.add(candidateSet[i]);
            recursiveHelper(combinationSum + candidateSet[i], target, i, candidateSet, pathTillNow);
            pathTillNow.remove(pathTillNow.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;

        CombinationSum cSum = new CombinationSum();
        System.out.println(cSum.combinationSum(arr, target));
    }
}

