package queue;

/**
 * Created by @Author tachai
 * date 2018/8/9 22:33
 *
 * @Email 1206966083@qq.com
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFornt();
}
