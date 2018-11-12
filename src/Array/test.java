package Array;

import java.util.List;

/**
 * Created by CP on 11/11/2018.
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
        Lc438 lc438 = new Lc438();
        String a = "cbaebabacd";
        String b = "abc";
        List<Integer> res=lc438.findAnagrams(a, b);
        printList(res);
    }
}
