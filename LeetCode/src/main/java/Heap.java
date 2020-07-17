public class Heap {

    /**
     *   Parent(i) : n/2
     *   Left(i) : i * 2 + 1  (Zero based Array
     *   Right(i) :  i * 2 + 2
     *   height : log n
     *
     *   Complexity:
     *      Needs log n comparisons to heapify
     *      Need n comparision's to build heap
     *      Need n Log n comparison's for heap sort
     */

    int[] heap;

    int heapSize;

    public void buildHeap(int[] arr) {
        heap = arr;
        heapSize = arr.length;
        for(int i= heapSize/2; i >= 0; i--){
            heapify(i);
        }
    }

    public void applyHeapSort(){

        while(heapSize >= 1){
            swap(heap, 0, heapSize-1);
            heapSize --;
            heapify(0);
        }

    }

    /**
     * Heapify is checking the heap property of the given heap position and fix if it violates.
     *
     * Complexity :  At max it need log n swaps to obtain heap  property.
     * @param i
     */
    public void heapify(int i) {
        int rIndex = right_zerobase(i); // right
        int lIndex = left_zerobase(i); // left
        int largest = i; //Biggest
        if (rIndex < heapSize && heap[i] < heap[rIndex]) {
            largest = rIndex;
        }
        if (lIndex < heapSize && heap[largest] < heap[lIndex]) {
            largest = lIndex;
        }
        if(largest != i) {
            swap(heap, largest, i);
            heapify(largest);
        }
    }

    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public int left_zerobase(int i) {
        return i * 2 + 1;
    }

    public int right_zerobase(int i) {
        return i * 2 + 2;
    }

    public void print() {
        for (int i : heap) {
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4,1,3,2,16,9,10,14,8,7};
        Heap heap = new Heap();
        heap.buildHeap(arr);
        heap.applyHeapSort();
        heap.print();
    }
}