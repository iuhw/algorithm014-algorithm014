import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列实践(double ended queue)：A linear collection that supports element insertion and removal at both ends.
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 * jdk 1.8
 * google keyword ： deque java 8  https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
 *
 **/
public class DequePractice {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList();

        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);
        // 取回头部元素，不删除，如果没有返回null
        Integer e = deque.peek();

        System.out.println(e);
        System.out.println(deque);
        while (deque.size()>0){
            // 弹出栈顶元素
            System.out.println(deque.pop());
        }
        System.out.println(deque);

        //  new api
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(3);

        deque.offerFirst(4);
        deque.offerLast(5);

        System.out.println(deque);

        int rf = deque.removeFirst();
        int rl = deque.removeLast();

        int pf = deque.pollFirst();
        int pl = deque.pollLast();

        int p = deque.poll();

        System.out.println(deque);

        //空，抛异常
//        deque.getFirst();
        //空，返回null
        Integer pef = deque.peekFirst();
        System.out.println(pef);

        //空，抛异常
//        deque.getLast();
        Integer pel = deque.peekLast();
        System.out.println(pel);

    }
}