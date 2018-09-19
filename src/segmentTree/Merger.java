package segmentTree;

/**
 * Created by @Author tachai
 * date 2018/9/19 23:16
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public interface Merger<E> {
    E merger(E a,E b);
}
