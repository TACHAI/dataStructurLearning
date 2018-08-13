package stack;

import LinkList.LinkedListPro;
import stack.Stack;

/**
 * Created by @Author tachai
 * date 2018/8/12 17:26
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class StackByLinkList<E> implements Stack<E>{
    private LinkedListPro<E> linkedListPro;
    public StackByLinkList(){
        linkedListPro = new LinkedListPro<>();
    }
    @Override
    public void push(E o) {
        linkedListPro.addFirst(o);
    }

    @Override
    public E pop() {
        return linkedListPro.removeFist();
    }

    @Override
    public E peek() {
        return linkedListPro.getFirst();
    }

    @Override
    public int getSize() {
        return linkedListPro.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedListPro.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(linkedListPro);
        return res.toString();
    }
}
