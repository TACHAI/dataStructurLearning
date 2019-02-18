package test;

import sun.jvm.hotspot.debugger.Address;

/**
 * Create by tachai on 2019-02-18 15:39
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class TestThread2  {

    public static void main(String[] args) {
        Mythread1 mythread1 = new Mythread1();
        mythread1.start();
    }

}

class Mythread1 extends Thread {

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("输出"+i);
        }
    }
}
