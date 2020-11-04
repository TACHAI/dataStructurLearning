package stack;

/**
 * Create by tachai on 2019-04-02 21:53
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface StackTest<T> {

    T pop();
    void push(T t);
    boolean isEmpty();
    int getSize();
}
