package Tree;


public class MinHeap {
    int[] heap;
    int index;

    MinHeap(int size) {
        heap = new int[size];
        index = -1;
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insertKey(int key) {
        index++;
        heap[index] = key;
        int curr = index;
        int par = parent(curr);
        while(curr!= 0 && heap[par] > heap[curr]) {
            swap(par, curr);
            curr = par;
            par = parent(curr);
        }
    }

    void minHeapify(int curr)
    {
        int left = leftChild(curr);
        int right = rightChild(curr);
        int s = curr;
        if(left <= index && heap[left] < heap[curr]) {
            s = left;
        }
        if(right <= index && heap[right] < heap[s]) {
            s = right;
        }
        if(s!=curr) {
            swap(curr, s);
            minHeapify(s);
        }


    }

    int extractMin() {
        if(index == -1) return -1;

        int root = heap[0];
        heap[0] = heap[index];
        index--;
        minHeapify(0);
        return root;
    }

    int leftChild(int i) {
        return 2*i+1; // 0 -> 1, 1 -> 3
    }

    int rightChild(int i) {
        return 2*i+2; // 0 -> 2, 1 -> 4
    }

    int parent(int i) {
        return (i-1)/2; // 2 -> 1, 4 -> 1 , 3 -> 1
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.insertKey(1);
        heap.insertKey(3);
        heap.insertKey(5);
        heap.insertKey(9);
        heap.insertKey(7);

        while (heap.index >= 0) {
            System.out.println(heap.extractMin());
        }

    }



}
