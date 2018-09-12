package set;

/**
 * Created by @Author tachai
 * date 2018/8/27 23:10
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
