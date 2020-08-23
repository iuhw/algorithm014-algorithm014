//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 637 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 使用代码模版递归
            List<Integer> ans = new ArrayList<>();
            // 递归
            helper(root, ans);
            return ans;
        }

        private void helper(TreeNode root, List<Integer> ans) {
            if (root != null) {
                // 左节点
                if (root.left != null) {
                    helper(root.left, ans);
                }
                ans.add(root.val);
                // 右节点
                if (root.right != null) {
                    helper(root.right, ans);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}