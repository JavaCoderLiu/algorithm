package class27.stream.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01List {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("赵敏");
        list.add("李白");
        list.add("张三丰");
        System.out.println(list);

        list.stream()
                .filter(s -> {
                    boolean flag = s.startsWith("张");
                    return flag;
                })
                .filter(s -> {
                    boolean flag = s.length() == 3;
                    return flag;
                })
                .forEach(System.out::println);

        System.out.println("---------------");
        System.out.println(list);


        Stream.of("1", "2", "3", "4", "5")
                .map(s -> {
                    return Integer.parseInt(s) * 2;
                })
                .forEach(System.out::println);

        String[] strArray = {"林,30", "张,35", "王,33", "柳,25"};
        Map<String, Integer> collect = Stream.of(strArray).filter(s -> {
            String[] strings = s.split(",");
            return Integer.parseInt(strings[1]) > 28;
        }).collect(Collectors.toMap(
                s -> {
                    String[] strings = s.split(",");
                    return strings[0];
                },
                s -> {
                    String[] strings = s.split(",");
                    return Integer.parseInt(strings[1]);
                }
        ));
        System.out.println(collect);
    }

}
