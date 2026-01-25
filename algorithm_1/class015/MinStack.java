package class015;

class MinStack {

    public final int MAXCapacity = 8001;
    public int[] data;
    public int[] min;

    public int size = 0;// 栈的元素数量

    public MinStack() {
        data = new int[MAXCapacity];
        min = new int[MAXCapacity];
    }

    public void push(int val) {
        if (size == 0) {
            data[size] = val;
            min[size] = val;
        } else {
            if (val < min[size-1]) {
                data[size] = val;
                min[size] = val;
            } else {
                data[size] = val;
                min[size] = min[size - 1];
            }
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
    }
}