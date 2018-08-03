package array;

/**
 * Created by @Author tachai
 * date 2018/8/3 22:39
 *
 * @Email 1206966083@qq.com
 */
public class Array {
    private int[] data;
    //有效的元素
    private int size;

    /**
     *
     * @param capacity 初始化容量
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 初始化默认容量为10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量的大小
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

//    /**
//     * 向数组后添加一个元素
//     * @param e
//     */
//    public void addLast(int e){
//        if(size < data.length){
//            data[size] = e;
//            size++;
//        }else {
//           int[] temp = new int[size+1];
//           size++;
//           for (int i:data){
//               temp[i]=data[i];
//           }
//            temp[size]=e;
//            data = temp;
//        }
//    }


    /**
     * 向数组后添加一个元素
     * @param e
     */
    public void addLast(int e){
        add(size,e);
    }


    /**
     * 在第index个位置插入一个新元素e
     * @param e
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,int e){
        if(size < data.length){
            if(index>0&index<size){
                for(int i= size-1;i>=index;i--){
                    data[i+1] = data[i];
                }
                data[index] = e;
                size ++;
            }
        }
    }

    /**
     * 获取元素的值
     * @param index
     * @return
     */
    public int get(int index){
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("Get failed,Index is illegal.");
        }
        return data[index];
    }

    /**
     * 设置元素的值
     * @param index
     * @param e
     * @return
     */
    public void set(int index, int e){
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("Get failed,Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组是否有元素e
     * @param e
     * @return
     */
    public boolean contains(int e){
        for(int i = 0;i<size;i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素
     * @param e
     * @return
     */
    public int find(int e){
        for(int i = 0; i < size; i++){
            if(data[1] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除元素，返回元素
     * @param index
     * @return
     */
    public int remove(int index){
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("Get failed,Index is illegal.");
        }
        int ret = data[size]''
        for(int i= index;i<size;i++){
            data[i] = data[i+1];
        }
        return ret;
    }

    /**
     * 删除某个元素
     * @param e
     */
    public boolean removeElement(int e){
        int index = find(e);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0;i < size ; i ++){
            res.append(data[i]);
            if(i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
