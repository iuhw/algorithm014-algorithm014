import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // 使用递归
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        dfs(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        // terminator
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // process

        // drill down
        dfs(i + 1, nums, ans, list);
        list.add(nums[i]);
        dfs(i + 1, nums, ans, list);

        // reverse
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
//        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
        System.out.println(subsets.subsets(new int[]{1, 2}));
    }
}