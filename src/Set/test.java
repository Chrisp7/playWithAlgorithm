package Set;

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
        int[][] num = new int[][]{{0, 0}, {1, 0}, {2, 0}};

        System.out.println(new Lc447().numberOfBoomerangs(num));
    }
}
