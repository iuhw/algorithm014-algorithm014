public class Leetcode236 {

    private TreeNode ans;

    public Leetcode236() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if (root == null) return false;
        // process
        // drill down
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
        // reverse
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        Leetcode236 leetcode236 = new Leetcode236();
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        int p = 5, q = 1;
        // 构建完全二叉树 （测试用例）
        TreeNode root = createBinaryTree(nums, 0);
        TreeNode res = leetcode236.lowestCommonAncestor2(root, new TreeNode(5), new TreeNode(1));
        System.out.println("7,4 LCA=" + res.val);
    }

    // 数组转完全二叉树 数组下标为index 的左节点 2*index+1 右节点 2*index+2

    /**
     * 由数组构建完全二叉树
     * 一棵由数组构建的完全二叉树，下标为n的节点左右子树分别是2n+1和2n+2
     */
    public static TreeNode createBinaryTree(Integer[] nums, int index) {
        // 遍历集合组装TreeNode  下标为n的节点左右子树分别是2n+1和2n+2
        int len = nums.length;
        TreeNode root = null;
        while (index < len) {
            root = new TreeNode(nums[index]);
            if (2 * index + 1 < len && nums[2 * index + 1] != null) {
                root.left = createBinaryTree(nums, 2 * index + 1);
            }
            if (2 * index + 2 < len && nums[2 * index + 2] != null) {
                root.right = createBinaryTree(nums, 2 * index + 2);
            }
            return root;
        }
        return null;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}