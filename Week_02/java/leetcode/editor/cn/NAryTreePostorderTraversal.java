//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 96 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        List<Integer> ans;

        public List<Integer> postorder(Node root) {
            ans = new ArrayList<>();
            helper(root);
            return ans;
        }

        private void helper(Node root) {
            if (root != null) {
                // child
                if (root.children != null) {
                    for (Node node : root.children) {
                        helper(node);
                    }
                    ans.add(root.val);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}