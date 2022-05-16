package adhoc;

public class TestAlti {

    private int a;
    TestAlti(int i) {
        a = i;
    }

    public int getVal() {
        return a;
    }

    public static void main(String[] args) {
        String s = "iamimrinal";

        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int index = ((int)c) - 97;

            arr[index] += 1;
        }

        int maxFreq = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > maxFreq) {
                maxFreq = arr[i];
                maxIndex = i;
            }
        }
        char ans = (char)(maxIndex + 97);
        System.out.println(ans);
    }
}
