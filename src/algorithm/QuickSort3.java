package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create by tachai on 2019-03-27 15:18
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */

// 三路排序
public class QuickSort3 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Collections.sort(list);

        int [] a = {2,1,4,3,2,5,7,3,7,3,12,3,6,8,4,9,0};
        quick(a);
        System.out.println(Arrays.toString(a));
    }


    private static void quick(int [] arr){
        if(arr!=null&& arr.length>0){
            quickSort(arr,0,arr.length-1);
        }
    }

    private static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }

        int key = arr[left];
        int low = left;
        int height = right+1;

        int i = left+1;

        System.out.println("+++"+i);
        while (i<height){
            if(arr[i] < key){
                swap(arr,low+1,i);
                i++;
                low++;
            }else if(arr[i]>key){
                swap(arr, height-1,i);
                height--;
            }else {
                i++;
            }
        }

        swap(arr,left,low);
        quickSort(arr,left,low-1);
        quickSort(arr,height,right);

    }

    private static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
