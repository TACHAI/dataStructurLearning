package stack;

import array.ArrayTest;

/**
 * Create by tachai on 2019-04-02 21:55
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ArrStackTest<T> implements StackTest<T> {

    public ArrayTest arrayTest;

    public ArrStackTest(){
        arrayTest = new ArrayTest();
    }


    @Override
    public T pop() {
        return (T) arrayTest.removeLast();
    }

    @Override
    public void push(T t) {
       arrayTest.addLast(t);
    }

    @Override
    public boolean isEmpty() {
        return arrayTest.isEmpty();
    }

    @Override
    public int getSize() {
        return arrayTest.getSize();
    }
}
