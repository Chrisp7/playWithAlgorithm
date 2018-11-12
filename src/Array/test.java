package Array;

/**
 * Created by CP on 11/11/2018.
 */

public class test {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[arr.length-1]);
    }

    public static void main(String[] args) {
        Lc215 lc215=new Lc215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k=4;
        int x=lc215.findKthLargest(nums,k);
        System.out.println(x);
    }
}
