package Set;

/**
 * Created by CP on 12/11/2018.
 */
public class test {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
    }
    public static void main(String[] args){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};

        int[] arr=new Lc350().intersect(nums1,nums2);
        printArray(arr);
    }
}
