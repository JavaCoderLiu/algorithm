package class23;

public class QuickSort {

    public static int CAPACITY = 100001;

    public static int[] arr = new int[CAPACITY];

    public static int first, last;

    public static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void quickSort1(int l, int r) {
        if (l >= r) {
            return;
        } else {
            int x = arr[l + (int) (Math.random() * (r - l + 1))];
            int mid = partition1(l, r, x);
            quickSort1(l, mid - 1);
            quickSort1(mid + 1, r);
        }
    }

    public static int partition1(int l, int r, int x) {
        int a = l;
        int xi = -1;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(a, i);
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi, a - 1);
        return a - 1;
    }

    public static void quickSort2(int l, int r) {
        if (l >= r) {
            return;
        } else {
            int x = arr[l + (int) (Math.random() * (r - l + 1))];
            partition2(l, r, x);
            int left = first;
            int right = last;
            quickSort2(l, left - 1);
            quickSort2(right + 1, r);
        }
    }

    public static void partition2(int l, int r, int x) {
        int a = l;
        int b = r;
        int i = l;
        while (i <= b) {
            if (arr[i] < x) {
                swap(i++, a++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(b--, i);
            }
        }
        first = a;
        last = b;
    }

    public static void main(String[] args) {

    }

}
