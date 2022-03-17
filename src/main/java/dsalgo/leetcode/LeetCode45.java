package dsalgo.leetcode;

public class LeetCode45 {

    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] ar = {2,2,3,1,4};
        LeetCode45 l45 = new LeetCode45();
        System.out.println(l45.jump(ar));
    }
}
