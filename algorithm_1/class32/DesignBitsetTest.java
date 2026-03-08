package class32;

public class DesignBitsetTest {

    class Bitset {

        private int[] set;
        private int size;
        private int zeros;
        private int ones;
        private boolean reverse;

        public Bitset(int n) {
            // 0~n-1
            set = new int[(n + 31) / 32];
            size = n;
            zeros = size;
            ones = 0;
            reverse = false;
        }

        public void fix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if (!reverse) {
                // 如果该位置没放进去
                if ((set[index] & (1 << bit)) == 0) {
                    zeros--;
                    ones++;
                    set[index] ^= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) != 0) {
                    zeros--;
                    ones++;
                    set[index] ^= (1 << bit);
                }
            }
        }

        public void unfix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if (!reverse) {
                // 如果该位置放进去
                if ((set[index] & (1 << bit)) != 0) {
                    zeros++;
                    ones--;
                    set[index] ^= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) == 0) {
                    zeros++;
                    ones--;
                    set[index] ^= (1 << bit);
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int temp = ones;
            ones = zeros;
            zeros = temp;
        }

        public boolean all() {
            return size == ones;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size; k++) {
                number = set[k];
                for (int j = 0; j < 32 && i < size; j++, i++) {
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    builder.append(status);
                }
            }
            return builder.toString();
        }

    }

}
