package algorithm;

import java.util.Arrays;

/**
 * Create by tachai on 2019-02-20 19:09
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class Test {


    public static void main(String[] args) {

            double [] a= {3,3,4,2,1,4.3243,6.434,3643,7.342,3.342};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(double[] a){
        if(a.length>0){
            sort(a,0,a.length-1);
        }
    }

    public static void sort(double[] a,int low,int height){
        int i=low;
        int j=height;
        // 退出条件
        if(i>j){
            return;
        }
        double key =  a[i];

        while(i<j){
            // 从右到左
            while (i<j&&a[j]>key){
                j--;
            }
            // 从左到右
            while (i<j&&a[i]<=key){
                i++;
            }

            if(i<j){
                double temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }

        // 交换key
        double temp = a[i];
        a[i]=a[low];
        a[low]=temp;

        sort(a,low,i-1);
        sort(a,i+1,height);
    }
}
