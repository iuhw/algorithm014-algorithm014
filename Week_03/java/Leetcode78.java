import java.util.ArrayList;
import java.util.List;

// 使用回溯方法解决
class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        Leetcode78 leetcode78 = new Leetcode78();
        List<List<Integer>> list = leetcode78.subsets(nums);
        System.out.println(list);
    }
}