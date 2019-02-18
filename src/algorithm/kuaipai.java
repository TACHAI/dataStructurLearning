package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by tachai on 2019-02-17 14:12
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class kuaipai {

    public static void main(String[] args) {
        int[] arr = {1,3,5,9,6,7,9,34,0,23};

        System.out.println(Arrays.toString(arr));


        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a){
        if(a.length>0){
            sort(a,0,a.length-1);
        }
    }



//            1，定义i=0，j=A.lenght-1，i为第一个数的下标，j为最后一个数下标
//            2，从数组的最后一个数Aj从右往左找，找到第一小于key的数，记为Aj；
//            3，从数组的第一个数Ai 从左往右找，找到第一个大于key的数，记为Ai；
//            4，交换Ai 和Aj 
//            5，重复这个过程，直到 i=j
//            6，调整key的位置，把A[i] 和key交换


    public static void sort(int[] a,int low,int high){
        int i =low;
        int j =high;


        if(i>j){
            return;
        }

        int k = a[i];


        while (i<j){
            while (i<j&&a[j]>k){
                j--;
            }

            while(i<j&&a[i]<=k){
                i++;
            }

            if(i<j){
                int swap =a[i];
                a[i] =a[j];
                a[j] =swap;
            }
        }

        k=a[i];
        a[i]=a[low];
        a[low]=k;

        sort(a,0,i-1);

        sort(a,i+1,high);
    }

}
