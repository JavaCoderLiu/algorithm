package class013;

public class QueueStackAndCircularQueue {

    private int[] queue;
    private int l = 0, r = 0, size = 0, limit = 0;// [l,r)

    public QueueStackAndCircularQueue(int k) {
        queue = new int[k];
        limit = k;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[l];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return (r == 0) ? queue[limit - 1] : queue[r - 1];
        }
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[r] = value;
            r = (r == limit - 1) ? 0 : r + 1;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            l = (l == limit - 1) ? 0 : l + 1;
            size--;
            return true;
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public boolean isFull() {
        if (size == limit) return true;
        else return false;
    }

}
