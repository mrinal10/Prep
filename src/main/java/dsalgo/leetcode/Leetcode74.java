package dsalgo.leetcode;

public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = (matrix.length * matrix[0].length) - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int midRow = mid / matrix[0].length;
            int midColumn = mid % matrix[0].length;

            int midvalue = matrix[midRow][midColumn];

            if(midvalue == target) {
                return true;
            } else if(midvalue < target) {
                start = mid+1;
            } else {//greater than target
                end = mid-1;
            }
        }
        return false;
    }
}
