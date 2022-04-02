package adhoc;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] maxFromRight = new int[n];
        int[] maxFromLeft = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < height[i]) {
                max = height[i];
            }
            maxFromLeft[i] = max;
        }

        max = 0;
        for (int i = n-1; i >= 0; i--) {
            if(max < height[i]) {
                max = height[i];
            }
            maxFromRight[i] = max;
        }

        int ans = 0;
        for (int i = 0; i<n; i++) {
            int curMax = Math.min(maxFromRight[i], maxFromLeft[i]);

            ans += (curMax - height[i]);
        }

        return ans;
    }
}
