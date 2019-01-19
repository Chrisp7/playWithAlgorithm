package DP;

public class Lc70 {
    private int[] arr;

    private int calcWays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (arr[n - 1] == 0)
            arr[n - 1] = calcWays(n - 1) + calcWays(n - 2);
        return arr[n - 1];
    }

    public int climbStairs(int n) {
        arr = new int[n];
        return calcWays(n);
    }
}
