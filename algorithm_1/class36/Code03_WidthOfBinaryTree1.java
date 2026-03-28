package class36;

public class Code03_WidthOfBinaryTree1 {

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

    public static int MAX_CAP = 3002;

    public static TreeNode[] queue = new TreeNode[MAX_CAP];

    public static int[] indexQ = new int[MAX_CAP];

    public static int l, r;

    public int widthOfBinaryTree(TreeNode root) {
        l = r = 0;
        queue[r] = root;
        indexQ[r++] = 1;
        int max = 1;
        while (l < r) {
            int size = r - l;
            max = Math.max(max, indexQ[r - 1] - indexQ[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l];
                int index = indexQ[l++];
                if (cur.left != null) {
                    queue[r] = cur.left;
                    indexQ[r++] = index * 2;
                }
                if (cur.right != null) {
                    queue[r] = cur.right;
                    indexQ[r++] = index * 2 + 1;
                }
            }
        }
        return max;
    }
}
