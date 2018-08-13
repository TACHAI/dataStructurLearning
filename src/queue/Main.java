package queue;

/**
 * Created by @Author tachai
 * date 2018/8/10 22:48
 *
 * @Email 1206966083@qq.com
 */
public class Main {

    //测试使用q运行opCount个enqueue和dequeue操作所需的时间，单位：秒
   private static String testQueue(Queue<Integer> queue,int opCoutn){
       long startTime = System.nanoTime();
       for (int i=0;i<opCoutn;i++){
           queue.enqueue(i);
       }
       long endTime = System.nanoTime();
       for (int i=0; i<opCoutn;i++){
           queue.dequeue();
       }
       long end = System.nanoTime();
       return "入栈"+(endTime-startTime)/1000000000.0+"出栈"+(end-endTime)/1000000000.0;
   }
    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(testQueue(arrayQueue,opCount));

        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(testQueue(loopQueue,opCount));
    }
}
