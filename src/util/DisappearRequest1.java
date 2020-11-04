package util;

/**
 * Create by tachai on 2019-09-12 16:28
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class DisappearRequest1 implements Runnable {

    static  DisappearRequest1 instance = new DisappearRequest1();


    static int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(instance);
        Thread t2= new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        // 执行完后会执行下一个
        System.out.println(i);

        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for(int j =0;j<100000;j++){
            i++;
        }
    }
}
