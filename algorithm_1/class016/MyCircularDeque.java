package class016;

class MyCircularDeque {

    int[] deque;
    int l, r, size, limit;

    public MyCircularDeque(int k) {
        deque = new int[k];
        l = 0;
        r = 0;
        size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else { // 可以新增
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                l = (l == 0) ? limit - 1 : l - 1;
                deque[l] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else { // 可以新增
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                r = (r == limit - 1) ? 0 : r + 1;
                deque[r] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            l = (l == limit - 1) ? 0 : l + 1;
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            r = (r == 0) ? limit - 1 : r - 1;
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[l];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[r];
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == limit) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        myCircularDeque.getRear();
        myCircularDeque.isFull();
        myCircularDeque.deleteLast();
        myCircularDeque.insertFront(4);
        myCircularDeque.getFront();
    }
}