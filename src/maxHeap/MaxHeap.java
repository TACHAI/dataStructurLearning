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

    public MaxHeap(E[] array){
        data = new Array<>(array);
        for(int i= parent(array.length-1);i>=0;i--){
            siftDown(i);
        }
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

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    //上浮
    private void siftUp(int k){
        while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k=parent(k);
        }
    }

    // 看堆中最大的元素
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("can't find max");
        }
        return data.get(0);
    }

    //取出堆最大的元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            int j= leftChild(k);
            if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0){
                j = rightChild(k);
                //data[j] 是左右孩子最大值
            }
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(k,j);
            k=j;
        }
    }
}
