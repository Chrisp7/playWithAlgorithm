package Sort;

public class MergeSort implements Sort {
    @Override
    public void Sort(int[] arr) {
        MergeSort(arr, 0, arr.length - 1);
    }

    private void MergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (right + left) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        for (int i = left; i < right + 1; i++) {
            temp[i - left] = arr[i];
        }
        int j = left;
        int k = mid + 1;
        for (int i = left; i < right + 1; i++) {

            if (j > mid) {
                arr[i] = temp[k-left];
                k++;
            } else if (k > right) {
                arr[i] = temp[j-left];
                j++;
            } else {
                if (temp[j - left] < temp[k - left]) {
                    arr[i] = temp[j - left];
                    j++;
                } else if (temp[j - left] >= temp[k - left]) {
                    arr[i] = temp[k - left];
                    k++;
                }
            }
        }
    }
}
