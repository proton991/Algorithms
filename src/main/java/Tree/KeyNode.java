package Tree;

import java.util.*;

public class KeyNode {
    private final Set<TreeNode> res;
    public KeyNode() {
        res = new HashSet<>();
    }
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x){
            val=x;
        }
        @Override
        public String toString(){
            return "val: "+val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public void dfs(TreeNode root, List<TreeNode> path) {
        if (root == null)
            return;
        if (path.size() == 0 || root.val >= path.get(path.size() - 1).val) {
            path.add(root);
            res.add(root);
        }
        if (root.left != null)
            dfs(root.left, new ArrayList<>(path));
        if (root.right != null)
            dfs(root.right, new ArrayList<>(path));

    }
    public int getKeyNodeCount(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, new ArrayList<>());
        int res = this.res.size();
        this.res.clear();
        return res;
    }

    public static void main(String[] args) {
        KeyNode solution = new KeyNode();


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(solution.getKeyNodeCount(root)==4);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.left.left = new TreeNode(2);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println(solution.getKeyNodeCount(root1)==3);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(1);
        root2.right.right = new TreeNode(5);
        System.out.println(solution.getKeyNodeCount(root2)==5);


    }
}
