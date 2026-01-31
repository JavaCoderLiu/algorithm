package class018;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 不用递归,用迭代的方式实现二叉树的三序遍历
public class BinaryTreeTraversalIteration {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }



    // 先序打印所有节点，非递归版
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            // 先右再左
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println();
    }

    // 中序打印所有节点，非递归版
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            // 遍历子树的左边
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
        System.out.println();
    }

    // 后序打印所有节点，非递归版
    // 这是用两个栈的方法
    public static void posOrderTwoStacks(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> col = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                col.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
            while (!col.isEmpty()) {
                System.out.print(col.pop().val + " ");
            }
            System.out.println();
        }
    }

    // 后序打印所有节点，非递归版
    // 这是用一个栈的方法
    public static void posOrderOneStack(TreeNode h) {
        List<Integer> list = new ArrayList<>();
        if (h != null) {
            // 如果始终没有打印过节点,h就一直是头节点
            // 一旦打印过节点,h就变成了打印节点
            // 之后h的含义:上一次打印的节点
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                } else {
                    h = stack.pop();
                    System.out.print(h.val + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preOrder(root);
        System.out.println("先序遍历非递归版");
        inOrder(root);
        System.out.println("中序遍历非递归版");
        posOrderTwoStacks(root);
        System.out.println("后序遍历非递归版 - 2个栈实现");
        posOrderOneStack(root);
        System.out.println("后序遍历非递归版 - 1个栈实现");
    }
}
