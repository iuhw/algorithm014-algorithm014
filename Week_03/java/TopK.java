import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
    public int majorityElement(int[] nums) {
        int len = (nums.length + 1) >> 1;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(len, Comparator.comparingInt(item -> -item));
        for (int num : nums) {
            pQueue.offer(num);
            if (pQueue.size() > len)
                pQueue.poll();
        }
        return pQueue.poll();
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        int maxelement = topK.majorityElement(new int[]{3, 2, 3});
        System.out.println(maxelement);
    }

}
