package adhoc;

//Input: 10 -5 -6 1 3 -2 20 -10 30
//output: -5 -6 -2 -10 10 1 3 20 30

// a b c d e
// f g h i j
// k l m n o

//a b c d e j o n m l k f
public class SNowTest {

    private static void print(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int r2 = row-1;

        int c = 0;
        int c2 = col - 1;

        while(r<r2 && c<c2) {

            for(int i=c; i<=c2; i++) {
                System.out.println(matrix[r][i]);
            }
            r++;
            for(int i=r; i<=r2; i++) {
                System.out.println(matrix[i][c2]);
            }
            c2--;
            for(int i=c2; i>=c; i--) {
                System.out.println(matrix[r2][i]);
            }
            r2--;
            for(int i=r2; i>=r; i--) {
                System.out.println(matrix[i][c]);
            }
            c++;
        }
    }

    public static void main(String[] args) {

        char[][] matrix = {{'a','b','c','d','e'},{'f', 'g', 'h', 'i', 'j'},{ 'k', 'l', 'm', 'n','o'}};
        print(matrix);
    }
}
