package Map;

/**
 * Created by @Author tachai
 * date 2018/9/6 21:42
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public interface Map<K,V> {
    void add(K k,V v);
    V remove(K k);
    boolean contains(K k);
    V get(K k);
    void set(K k,V v);
    int getSize();
    boolean isEmpty();
}
