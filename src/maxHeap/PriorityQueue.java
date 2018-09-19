package maxHeap;

import queue.Queue;

/**
 * Created by @Author tachai
 * date 2018/9/16 19:02
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFornt() {
        return maxHeap.findMax();
    }
}
