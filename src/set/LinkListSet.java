package set;

import LinkList.LinkedList;
import LinkList.LinkedListPro;

/**
 * Created by @Author tachai
 * date 2018/8/29 23:14
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class LinkListSet<E> implements Set<E> {
    private LinkedListPro<E> list;
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElment(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
