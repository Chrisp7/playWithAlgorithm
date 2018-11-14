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

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";

        System.out.println(new Lc290().wordPattern(pattern, str));
    }
}
