package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by tachai on 2019-02-17 15:37
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class quickSort {

    public static void main(String[] args) {
        double[] a ={9.32,9.12,2,3,2,4,5,3,8,5,4,1,1,2};

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void sort(double[] a){
        if(a.length>0){
           sort(a,0,a.length-1);
        }
    }

    public static void sort(double[] a,int low,int heigh){

        int i=low;
        int j=heigh;


        // 递归退出条件
        if(i>j){
            return;
        }
        // 记录key
        double key=a[i];

        while(i<j){
            // 从右到左找出比key小的值
            while (i<j&&a[j]>key){
                j--;
            }
            // 从左到右找出比key大的值
            while(i<j&&a[i]<=key){
                i++;
            }

            // 替换两值
            if(i<j){
               double temp =a[i];
               a[i]=a[j];
               a[j]=temp;
            }
        }

        // 替换key的值
        double temp = a[i];
        a[i]=a[low];
        a[low]=temp;
        // 递归左边
        sort(a,low,i-1);
        // 递归右边
        sort(a,i+1,heigh);


    }



}
