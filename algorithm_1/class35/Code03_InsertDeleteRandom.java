package class35;

import java.util.ArrayList;
import java.util.HashMap;

public class Code03_InsertDeleteRandom {

    class RandomizedSet {

        public HashMap<Integer, Integer> map;

        public ArrayList<Integer> arr;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer index = map.get(val);
            if (index != arr.size() - 1) {
                Integer lastValue = arr.getLast();
                arr.set(index, lastValue);
                map.put(lastValue, index);
            }
            arr.remove(arr.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }

    }

    public static void main(String[] args) {

    }

}
