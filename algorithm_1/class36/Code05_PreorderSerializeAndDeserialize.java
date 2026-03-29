package class36;

public class Code05_PreorderSerializeAndDeserialize {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        f(root, builder);
        return builder.toString();
    }

    public void f(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
        } else {
            builder.append(root.val).append(",");
            f(root.left, builder);
            f(root.right, builder);
        }
    }

    public static int cur = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] treeText = data.split(",");
        if (treeText.length == 0) return null;
        cur = 0;
        return g(treeText);
    }

    public TreeNode g(String[] treeText) {
        String node = treeText[cur++];
        if ("#".equals(node)) {
            return null;
        } else {
            TreeNode treeNode = new TreeNode(Integer.parseInt(node));
            treeNode.left = g(treeText);
            treeNode.right = g(treeText);
            return treeNode;
        }
    }
}
