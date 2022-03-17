package important450.array;

public class Min_Jump_to_reach_end {
    //Recursive_approach
    private int minJumps(int[] ar, int curIndx, int stepsTillNow) {
        if(ar.length-1 == curIndx) {

        }
        int stepsCount = ar[curIndx];

        return 0;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        Min_Jump_to_reach_end minJumpsToReach = new Min_Jump_to_reach_end();
        System.out.print("Minimum number of jumps to reach end is "
                + minJumpsToReach.minJumps(arr, 0, 0));
    }
}
