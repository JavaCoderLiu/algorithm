package class36;

import java.util.ArrayList;
import java.util.List;

public class Code02_ZigzagLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int MAX_CAP = 2002;

    public static TreeNode[] queue = new TreeNode[MAX_CAP];

    public static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            boolean reverse = false;
            l = r = 0;
            queue[r++] = root;
            while (l < r) {
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; k++, i += j) {
                    list.add(queue[i].val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
                reverse = !reverse;
            }
        }
        return ans;
    }

}
