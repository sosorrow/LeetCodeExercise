package deque;

public class CircularDeque {
    public static void main(String[] args) {
        // ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
        // [[3],[1],[2],[3],[4],[],[],[],[4],[]]

        CircularDeque cd = new CircularDeque(3);
        cd.insertLast(1);
        cd.insertLast(2);
        cd.insertFront(3);
        cd.insertFront(4);
        cd.deleteLast();
        cd.insertFront(4);
    }

    private int max = 0;
    private int size = 0;
    private int[] arrays;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        this.max = k;
        this.arrays = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.size == this.max) return false;
        for (int i=this.size; i > 0; i--) {
            this.arrays[i] = this.arrays[i - 1];
        }
        this.arrays[0] = value;
        this.size++;
        for (int a : this.arrays) System.out.print(a + "  ");
        System.out.println();
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.size == this.max) return false;
        this.arrays[this.size++] = value;
        for (int a : this.arrays) System.out.print(a + "  ");
        System.out.println();
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.size == 0) return false;
        for (int i=0; i<this.size - 1; i++) {
            this.arrays[i] = this.arrays[i+1];
        }
        this.size--;
        for (int a : this.arrays) System.out.print(a + "  ");
        System.out.println();
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.size == 0) return false;
        this.arrays[--this.size] = 0;
        for (int a : this.arrays) System.out.print(a + "  ");
        System.out.println();
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()) return -1;
        return this.arrays[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()) return -1;
        return this.arrays[this.size - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == this.max;
    }
}
