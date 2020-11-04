package util;

/**
 * Create by tachai on 2019-09-12 16:49
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class SynchronizeObjectCodeBlock2 implements Runnable
{

    static SynchronizeObjectCodeBlock2 instance = new SynchronizeObjectCodeBlock2();
    static SynchronizeObjectCodeBlock2 instance2 = new SynchronizeObjectCodeBlock2();


    Object object =new Object();

    @Override
    public void run() {
        for(int j=0;j<10000;j++){
            synchronized (SynchronizeObjectCodeBlock2.class){
                System.out.println("实例对象名"+Thread.currentThread().getName());
                i++;
            }
        }

    }

    static  int i=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.println(i);
    }


}
