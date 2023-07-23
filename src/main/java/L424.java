public class L424 {
    public int characterReplacement(String s, int k) {

        int ans = 0;
        int maxCount = 0;
        int[] count = new int[128];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            maxCount = Math.max(maxCount, ++count[s.charAt(r)]);
            while (maxCount + k < r - l + 1) {
                --count[s.charAt(l++)];
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        L424 l424 = new L424();
        System.out.print(l424.characterReplacement("ABBAB", 2));
    }
}
