package salesforce;

public class DivisibleString {

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    private static String findSmallestString(String a, String b) {
        int m = a.length();
        int n = b.length();

        int lcm = lcm(m, n);

        String s1 = "";
        for(int i=0; i<lcm/m; i++) {
            s1 += a;
        }

        String s2 = "";
        for(int i=0; i<lcm/n; i++) {
            s2 += b;
        }

        if(s1.equals(s2)) {
            return s1;
        } 

        return "-1";
    }


    public static void main(String[] args){
        String S = "baqba", T = "ba";
        System.out.println(findSmallestString(S, T));
    }
}
