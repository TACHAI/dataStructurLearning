package segmentTree;

/**
 * Created by @Author tachai
 * date 2018/9/19 22:53
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
//线段树
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger=merger;
        data = (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        tree = (E[]) new Object[arr.length*4];
        buildSegmentTree(0,0,data.length-1);
    }
    private void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftTreeIndex = leftChild(l);
        int rightTreeIndex = rightChild(r);
        int mid =l+(r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
       // tree[treeIndex]=tree[leftTreeIndex]+tree[rightTreeIndex];
        tree[treeIndex]=merger.merger(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>=data.length)
            throw new IllegalArgumentException("index is illegal");
            return data[index];
    }

    //更新
    public void set(int index,E e){
        if(index<0||index>=data.length){
            throw  new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    private void set(int treeIndex,int l,int r,int index, E e){
        if(l==r){
            tree[treeIndex]=e;
            return;
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTrddIndex = rightChild(treeIndex);
        if(index>=mid+1){
            set(rightTrddIndex,mid+1,r,index,e);
        }else {
            set(leftTreeIndex,l,mid,index,e);
        }
        tree[treeIndex]=merger.merger(tree[leftTreeIndex],tree[rightTrddIndex]);
    }

//    public void update(int index,int val){
//        if(se)
//    }


    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }
}
