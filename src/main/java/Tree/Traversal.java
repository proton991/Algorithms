package Tree;

import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2021/1/28 09:53
 * @Description:
 */
public class Traversal {

    public void visit(TreeNode node){
        System.out.print(node.val+" ");
    }

    public void perOrderRecursion(TreeNode node) {
        if (node == null)
            return;
        visit(node);
        perOrderRecursion(node.left);
        perOrderRecursion(node.right);
    }

    public List<Integer> preOrderIteration(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    public List<Integer> inOrderIteration(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> postOrderIteration(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

}
