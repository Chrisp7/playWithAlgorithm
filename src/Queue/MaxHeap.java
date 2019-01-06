package Queue;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // return size of heap
    public int size() {
        return data.getSize();
    }

    // isEmpty
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    public E peek() {
        if (data.getSize() == 0) throw new IllegalArgumentException("there is no element in the heap");
        else return data.get(0);
    }

    public E extractMax() {
        E res = peek();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) j++;
            if (data.get(i).compareTo(data.get(j)) > 0) break;
            data.swap(i, j);
            i = j;
        }
    }

    // get parent index
    private int parent(int i) {
        if (i == 0) throw new IllegalArgumentException("index 0 doesn't have parent");
        else
            return (i - 1) / 2;
    }

    // get left child index
    private int leftChild(int i) {
        return i * 2 + 1;
    }

    // get right child index
    private int rightChild(int i) {
        return i * 2 + 2;
    }
}
