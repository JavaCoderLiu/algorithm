package class27.lambda.demo1;

public class LambdaTest {
    public static void main(String[] args) {
        // 1.子类实现接口
        Factory factory = new SubClass();
        User user1 = (User) factory.getObject();
        System.out.println(user1);

        // 2.匿名内部类
        factory = new Factory() {
            @Override
            public Object getObject() {
                return new User(18, "张三");
            }
        };
        User user2 = (User) factory.getObject();
        System.out.println(user2);

        // 3.lambda表达式
        factory = () -> {
            return new User(20, "刘学谦");
        };
        User user3 = (User) factory.getObject();
        System.out.println(user3);

        // lambda作为参数进行传递

    }
}
