package stack;

import array.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @Author tachai
 * date 2018/8/7 22:54
 *
 * @Email 1206966083@qq.com
 */
public class ArrayStack<E> implements Stack {
    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public void push(Object e) {
        array.addLast((E)e);
    }


    @Override
    public E pop() {
       return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize()-1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('【');
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!= array.getSize()-1){
                res.append(", ");
            }
            res.append("】top");
        }
        return res.toString();
    }
}
