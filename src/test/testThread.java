package test;

/**
 * Create by tachai on 2019-02-18 15:37
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class testThread  {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());

        thread.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {

        for(int i=0;i<100;i++){
            System.out.println("["+i+"]");
        }
    }
}