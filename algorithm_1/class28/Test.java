package class28;

public class Test {
    public static void main(String[] args) {
        outer:
        for (; ; ) {
            System.out.println("1111");
            inner:
            for (; ; ) {
                System.out.println("2222");
                break outer;
            }
        }
        xxx:
        if (true) {
            System.out.println("3333");
            break xxx;
        }
        yyy:
        while (true) {
            System.out.println("4444");
            break yyy;
        }
    }
}

/**
 * 运行结果:
 * 1111
 * 2222
 * 3333
 * 4444
 */
