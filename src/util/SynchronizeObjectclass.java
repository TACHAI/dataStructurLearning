package util;

/**
 * Create by tachai on 2019-09-12 16:49
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class SynchronizeObjectclass implements Runnable
{

    static SynchronizeObjectclass instance1 = new SynchronizeObjectclass();
    static SynchronizeObjectclass instance2 = new SynchronizeObjectclass();


    static  int i=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.println(i);
    }


    @Override
    public void run() {
        method();

    }


    public    void method(){


        synchronized (SynchronizeObjectclass.class){
            System.out.println("我是对象锁的方法修饰符形式，我叫"+Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }

    }


}
