package liked;

public class Lc11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[r] < height[l]) r--;
            else l++;
        }
        return res;
    }
}
