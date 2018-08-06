package array;

/**
 * Created by @Author tachai
 * date 2018/8/3 22:39
 *
 * @Email 1206966083@qq.com
 */
public class Array<E> {
    private E[] data;
    //有效的元素
    private int size;

    /**
     * @param capacity 初始化容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 初始化默认容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量的大小
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
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
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 在第index个位置插入一个新元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed require index>=0 and index < size");
        }

        if (size >= data.length) {
           resize(data.length*2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;


    }

    /**
     * 获取元素的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        return data[index];
    }

    /**
     * 设置元素的值
     *
     * @param index
     * @param e
     * @return
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[1].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除元素，返回元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        E ret = data[size];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
//        for(int i= index+1;i<size;i++){
//            data[i-1] = data[i];
//        }
        size--;
        data[size] = null;//loitering objects != memory leak(内存泄漏)
       //lazy
        if(size==data.length/4&&data.length/2!=0){
           resize(data.length/2);
       }
        return ret;
    }

    /**
     * 删除某个元素
     *
     * @param e
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
