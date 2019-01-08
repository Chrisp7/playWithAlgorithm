package Sort;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 10, 3, 6, 9, 5, 8};
        Sort s = new MergeSort();
        s.Sort(arr);
        printArr(arr);

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ,");
        }
        System.out.print(arr[arr.length - 1]);
    }
}
