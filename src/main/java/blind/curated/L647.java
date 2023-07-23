package blind.curated;

public class L647 {

    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            count += countHelper(s, i, i);
            count += countHelper(s, i, i+1);
        }

        return count;
    }

    private int countHelper(String s, int l, int r) {
        int count = 0;
        while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
            count++;
        }
        return count;
    }
}
