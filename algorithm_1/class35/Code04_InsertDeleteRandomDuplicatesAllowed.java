package class35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Code04_InsertDeleteRandomDuplicatesAllowed {

    class RandomizedCollection {

        public HashMap<Integer, Set<Integer>> map;

        public ArrayList<Integer> arr;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            int size = arr.size();
            arr.add(val);
            if (map.containsKey(val)) {
                map.get(val).add(size);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(size);
                map.put(val, set);
            }
            return map.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Set<Integer> valSet = map.get(val);
            Integer valAnyIndex = valSet.iterator().next();
            Integer endValue = arr.get(arr.size() - 1);
            if (val == endValue) {
                valSet.remove(arr.size() - 1);
            } else {
                Set<Integer> endValueSet = map.get(endValue);
                endValueSet.add(valAnyIndex);
                arr.set(valAnyIndex, endValue);
                endValueSet.remove(arr.size() - 1);
                valSet.remove(valAnyIndex);
            }
            arr.remove(arr.size() - 1);
            if (valSet.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

}
