package important450.array;

import java.util.Arrays;

public class MS {

    public int solution(int[] A) {
        double sum = Arrays.stream(A).sum();
        int maxTrees = (int) Math.ceil(sum/A.length);

        int ops = 0;

        for(int i : A) {

            int diff = maxTrees - i;
            if(diff > 0)
                ops += diff;
        }
        return ops;
    }

    public static void main(String[] args) {
        int[] A = {1,1,3,1}; //{4,2,4,6}; //{1,2,2,4};

        MS ms = new MS();
        System.out.println(ms.solution(A));
    }
}
