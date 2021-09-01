package dsalgo.backtrack.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem39 {
    List<List<Integer>> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new ArrayList<>();
        rec(0, target, 0, candidates, new ArrayList<>());
        return path;
    }

    private void rec(int curSum, int target, int index, int[] candidateSet, List<Integer> curPath) {
        if(curSum > target) {
            return;
        }

        if(curSum == target) {
            List<Integer> temp = new ArrayList();
            temp.addAll(curPath);
            path.add(temp);
            return;
        }

        for(int i = index; i<candidateSet.length; i++) {
            curPath.add(candidateSet[i]);
            rec(curSum + candidateSet[i], target, i, candidateSet, curPath);
            curPath.remove(curPath.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        Problem39 p39 = new Problem39();
        List<List<Integer>> pathRes = p39.combinationSum(arr, target);

        for(List<Integer> candidates : pathRes) {
            for(Integer candidate : candidates) {
                System.out.print(candidate+" ");
            }
            System.out.println("");
        }
    }

}
