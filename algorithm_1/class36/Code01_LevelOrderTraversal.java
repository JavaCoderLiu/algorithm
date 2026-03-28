package class36;

import java.util.*;

public class Code01_LevelOrderTraversal {

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

    /**
     * 采用原生的队列实现层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            HashMap<TreeNode, Integer> levels = new HashMap<>();
            queue.add(root);
            levels.put(root, 0);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                // 代表当前层次还没有元素
                if (ans.size() == levels.get(cur)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    ans.add(list);
                } else {
                    ans.get(levels.get(cur)).add(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                    levels.put(cur.left, levels.get(cur) + 1);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    levels.put(cur.right, levels.get(cur) + 1);
                }
            }
        }
        return ans;
    }

    public static int MAX_CAP = 2002;

    public static TreeNode[] queue = new TreeNode[MAX_CAP];

    public static int l, r;

    /**
     * 用数组模拟队列实现层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            HashMap<TreeNode, Integer> levels = new HashMap<>();
            queue[r++] = root;
            levels.put(root, 0);
            while (l < r) {
                TreeNode cur = queue[l++];
                // 代表当前层次还没有元素
                if (ans.size() == levels.get(cur)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    ans.add(list);
                } else {
                    ans.get(levels.get(cur)).add(cur.val);
                }
                if (cur.left != null) {
                    queue[r++] = cur.left;
                    levels.put(cur.left, levels.get(cur) + 1);
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                    levels.put(cur.right, levels.get(cur) + 1);
                }
            }
        }
        return ans;
    }

}
