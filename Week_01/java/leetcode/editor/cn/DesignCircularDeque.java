//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 54 👎 0


package leetcode.editor.cn;

public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque solution = new DesignCircularDeque().new MyCircularDeque(3);
        boolean param_1 = solution.insertFront(1);
        boolean param_2 = solution.insertLast(2);
        int param_5 = solution.getFront();
        int param_6 = solution.getRear();
        boolean param_3 = solution.deleteFront();
        boolean param_4 = solution.deleteLast();
        boolean param_7 = solution.isEmpty();
        boolean param_9 = solution.insertFront(1);
        boolean param_10 = solution.insertLast(2);
        boolean param_11 = solution.insertLast(3);
        boolean param_8 = solution.isFull();

        System.out.println(String.format("%b %b %d %d %b %b %b %b %b %b", param_1, param_2,
                param_5, param_6, param_3, param_4, param_7, param_9, param_10, param_11, param_8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        //切题： 循环  双端

        // 用数组实现
        // front = rear 空
        // rear+1 = front 满
        private int capacity;
        private int[] arr;
        private int front;
        private int rear;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            capacity = k + 1;
            arr = new int[capacity];
            front = 0;
            rear = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            // 判断是否已经满了
            if (isFull()) {
                return false;
            }
            // 在头部插入 先减1 再赋值 避免下标溢出
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;

            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            // 判断是否已经满了
            if (isFull()) {
                return false;
            }
            // 在尾部插入  rear先赋值  rear++  避免下表溢出
            arr[rear] = value;
            rear = (rear + 1) % capacity;

            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            // 判断是否为空
            if (isEmpty()) {
                return false;
            }
            // front加1 考虑下标溢出
            front = (front + 1) % capacity;

            return true;

        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            // 判断是否为空
            if (isEmpty()) {
                return false;
            }
            // rear减1 考虑下标溢出
            rear = (rear - 1 + capacity) % capacity;

            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            // 判断是否为空
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            // 判断是否为空
            if (isEmpty()) {
                return -1;
            }
            return arr[(rear - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return front == (rear + 1) % capacity;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}