package SetAndMap;

import java.util.*;


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

    public static <T> void printList(List<T> arr) {
        for (T t : arr) {
            System.out.print(t + ",");
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,2147483647};
        int k = 1;
        int t = 2147483647;

        System.out.println(new Lc220().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
