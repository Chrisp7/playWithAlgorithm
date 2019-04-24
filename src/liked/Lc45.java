package liked;

public class Lc45 {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=0;
        for(int i=0;i<dp.length;i++){
            for(int j=1;j<=nums[i];j++){
                if(i+j<=dp.length-1){
                    if(dp[i+j]==0) dp[i+j]=dp[i]+1;
                    else dp[i+j]=Math.min(dp[i+j],dp[i]+1);

                    if(i+j==dp.length-1) break;
                }

            }
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args){
        int[] nums = {3,4,3,2,5,4,3};
        System.out.println(jump(nums));
    }
}
