package algorithm;

import java.util.Arrays;

/**
 * Create by tachai on 2019-03-28 20:25
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int a[] ={3,1,3,5,2,6,4,7,0,12,8,9};

        sort(a);

        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        if(a.length>0){
            sort(a,0,a.length-1);
        }
    }


    public static void sort(int[] a,int low,int height){

        int i =low;
        int j = height;

        if(i>j){
            return;
        }

        int key = a[i];

        while (i<j){

            //重大到小
//            while (i<j&&a[j]<key){
//                j--;
//            }
//
//            while (i<j&&a[i]>=key){
//                i++;
//            }
            // 找出比j小的值
            while (i<j&&a[j]>key){
                j--;
            }
            // 找出比i大的值
            while (i<j&&a[i]<=key){
                i++;
            }

            if(i<j){
                int temp = a[j];
                a[j] =a[i];
                a[i] = temp;
            }

        }

        key =a[i];
        a[i] =a[low];
        a[low] =key;

        sort(a,low,i-1);
        sort(a,i+1,height);
    }
}
