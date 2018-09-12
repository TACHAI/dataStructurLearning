package maxHeap;

import array.Array;

/**
 * Created by @Author tachai
 * date 2018/9/12 23:11
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
// E extends Comparable<E> 必须实现了comparable

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }
    //返回堆中 的元素个数
    public int size(){
        return data.getSize();
    }
    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点
    private int parent(int index){
        if(index==0){
            throw  new IllegalArgumentException("index=0 dones't have parent");
        }
        return (index-1)/2;
    }
    //返回完全二叉树的数组中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index*2+1;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的右孩子节点索引
    private int rightChild(int index){
        return index*2+2;
    }
}
