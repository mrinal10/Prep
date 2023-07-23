package important450;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int rightSide = height.length - 1;
        int leftSide = 0;

        int maxArea = Math.min(height[leftSide], height[rightSide]) * (rightSide - leftSide);
        while(leftSide < rightSide) {
            if(height[leftSide] < height[rightSide]) {
                leftSide++;
            } else {
                rightSide--;
            }

            int area = Math.min(height[leftSide], height[rightSide]) * (rightSide - leftSide);
            if(maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
