class L392 {
    public boolean isSubsequence(String s, String t) {
       
       int sLen = s.length();
       int tLen = t.length();
       
        int si = 0;
        int ti = 0;


        while(si < sLen && ti < tLen) {
            if(s.charAt(si) == t.charAt(ti)){
                si++;
            }
            ti++;
        }

        if(ti == tLen) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        L392 l392 = new L392();

        l392.isSubsequence(s, t);
    }
}