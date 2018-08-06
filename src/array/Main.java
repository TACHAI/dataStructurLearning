package array;

/**
 * Created by @Author tachai
 * date 2018/8/6 0:04
 *
 * @Email 1206966083@qq.com
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for(int i=0;i<10;i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);

    }
}
