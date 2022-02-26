package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[] websiteVisits = new int[n];
        for(int i_websiteVisits = 0; i_websiteVisits < n; i_websiteVisits++)
        {
            int temp = Integer.parseInt(br.readLine().trim());
            websiteVisits[i_websiteVisits] = temp;
        }
        int m = Integer.parseInt(br.readLine().trim());
        int[] appVisits = new int[m];
        for(int i_appVisits = 0; i_appVisits < m; i_appVisits++)
        {
            int temp = Integer.parseInt(br.readLine().trim());
            appVisits[i_appVisits] = temp;
        }

        int out_ = computeDeviceCrossovers(n, websiteVisits, m, appVisits);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static int computeDeviceCrossovers(int n, int[] websiteVisits,
            int m, int[] appVisits) {
        // Write your code here
        int result = 0;
        List<String> switchList = new ArrayList();
        int i = 0;
        int j = 0;

        while(i < n && j < m) {
            if(websiteVisits[i] < appVisits[j]) {
                switchList.add("website");
                i++;
            } else {
                switchList.add("app");
                j++;
            }
        }
        while(i < n) {
            switchList.add("website");
            i++;
        }

        while(j < m) {
            switchList.add("app");
            j++;
        }


        i = 0;
        while(i < switchList.size()-1) {
            String it = switchList.get(i);
            if(it!=switchList.get(i+1)) {
                result++;
            }
            i++;
        }
        return result;

    }
}
