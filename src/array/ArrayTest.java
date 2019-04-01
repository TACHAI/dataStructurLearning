package array;

/**
 * Create by tachai on 2019-03-27 16:57
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ArrayTest<T> {
    private T[] data;
    private int size;

    //初始化
    public ArrayTest(int captional){
        this.data = (T[]) new Object[captional];
        this.size=0;
    }

    public ArrayTest(){
        this(10);
    }

    //带值的初始化
    public ArrayTest(T[] arr){
       int l = arr.length;
       this.data = (T[]) new Object[l];
       for(int i=0;i<l;i++){
           data[i]=arr[i];
       }
       size=l;
    }

    //size 大小
    public int getSize(){
        return size;
    }

    //是否为空
    public boolean isEmpty(){
        return size==0;
    }


    // 增
    public void add(int index,T t){

        if(index<0||index>size){
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }

        if(size>=data.length){
            resize(data.length*2);
        }

        for(int i=size-1;i>index;i--){
            data[i+1]=data[i];
        }
        data[index]=t;
        size++;
    }

    //删 todo 缩小大小
    public void del(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }

        for(int i=index;i<size;i++){
            data[i]=data[i+1];
        }

        size--;
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        data[size]=null;

    }
    //改
    public void set(int index,T t){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }
        data[index]=t;
    }
    //查
    public int find(T t){

        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return i;
            }
        }

        return -1;
    }
    //是否有该元素
    public boolean contain(T t){
        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return true;
            }
        }

        return false;
    }

    //获取元素的值
    public T get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }
        return data[index];
    }


    private void resize(int newCapacity){
        T[] temp = (T[]) new Object[newCapacity];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

}
