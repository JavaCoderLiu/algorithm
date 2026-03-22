package class35;

import java.util.HashMap;

public class Code01_SetAllHashMap {

    public static HashMap<Integer, int[]> map = new HashMap<>();

    public static int setAllValue;

    public static int setAllTime;

    public static int cnt;

    public static void put(int k, int v) {
        if (map.containsKey(k)) {
            int[] value = map.get(k);
            value[0] = v;
            value[1] = cnt++;
        } else {
            map.put(k, new int[]{v, cnt++});
        }
    }

    public static void setAll(int v) {
        setAllValue = v;
        setAllTime = cnt++;
    }

    public static int get(int k) {
        if (!map.containsKey(k)) {
            return -1;
        }
        int[] value = map.get(k);
        return setAllTime > value[1] ? setAllValue : value[0];
    }

}
