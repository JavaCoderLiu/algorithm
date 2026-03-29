package class36;

public class Code06_LevelorderSerializeAndDeserialize {

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int MAXN = 10001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(root.val).append(",");
            l = r = 0;
            queue[r++] = root;
            while (l < r) {
                TreeNode cur = queue[l++];
                if (cur.left != null) {
                    builder.append(cur.left.val).append(",");
                    queue[r++] = cur.left;
                } else {
                    builder.append("#,");
                }
                if (cur.right != null) {
                    builder.append(cur.right.val).append(",");
                    queue[r++] = cur.right;
                } else {
                    builder.append("#,");
                }
            }
        }
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) return null;
        String[] split = data.split(",");
        int index = 0;
        l = r = 0;
        TreeNode head = new TreeNode(Integer.parseInt(split[index++]));
        queue[r++] = head;
        while (l < r) {
            TreeNode cur = queue[l++];
            cur.left = g(split[index++]);
            cur.right = g(split[index++]);
            if (cur.left != null) queue[r++] = cur.left;
            if (cur.right != null) queue[r++] = cur.right;
        }
        return head;
    }

    private TreeNode g(String s) {
        return "#".equals(s) ? null : new TreeNode(Integer.parseInt(s));
    }
}
