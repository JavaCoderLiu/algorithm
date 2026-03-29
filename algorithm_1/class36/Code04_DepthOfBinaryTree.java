package class36;

public class Code04_DepthOfBinaryTree {

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

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            int lDeep = Integer.MAX_VALUE;
            int rDeep = Integer.MAX_VALUE;
            if (root.left != null) {
                lDeep = minDepth(root.left);
            }
            if (root.right != null) {
                rDeep = minDepth(root.right);
            }
            return Math.min(lDeep, rDeep) + 1;
        }
    }

}
