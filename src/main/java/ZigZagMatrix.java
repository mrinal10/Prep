import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagMatrix {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        int rows = array.size();
        int columns = array.get(0).size();
        List<Integer> ans = new ArrayList<>();
        int row = 0;
        int column = 0;
        boolean topToDown = true;

        while((row < rows) && (column < columns)) {
            ans.add(array.get(row).get(column));
            if(column == 0 && topToDown && row != rows - 1) {
                row++;
                topToDown = !topToDown;
            } else if(row == 0 && !topToDown && column != columns - 1) {
                column++;
                topToDown = !topToDown;
            } else if( (column == (columns - 1)) && !topToDown) {
                row++;
                topToDown = !topToDown;
            } else if(row == rows - 1  && topToDown) {
                column++;
                topToDown = !topToDown;
            } else if(!topToDown) {
                row--;
                column++;
            } else {
                row++;
                column--;
            }
        }
        return ans;
   }

  public static void main(String[] args) {
    List<List<Integer>> test = new ArrayList<List<Integer>>();
    test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
    test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
    test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
    test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));
    
    zigzagTraverse(test);
  }
}
