package adhoc;

public class AllPermutation_String {
    public static void main(String[] args)
    {
        String str = "ABC";
        AllPermutation_String permutation = new AllPermutation_String();
        permutation.permute(str, 0);
    }

    public void permute(String s, int startIndex) {
        int len = s.length()-1;

        if(startIndex==len) {
            System.out.println(s);
        } else {
            for (int i = startIndex; i <= len; i++) {
                s = swap(s, i, len);
                permute(s, startIndex+1);
                s = swap(s, i, len);
            }
        }
    }

    private String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp =  ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return String.valueOf(ch);
    }
}
