package stack;

/**
 * Created by @Author tachai
 * date 2018/8/7 22:45
 *
 * @Email 1206966083@qq.com
 */
public interface  Stack<E> {
    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
