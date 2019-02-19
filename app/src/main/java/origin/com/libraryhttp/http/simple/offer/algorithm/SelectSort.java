package origin.com.libraryhttp.http.simple.offer.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * Created by zc on 2019/2/19
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr [] = {4,3,2,1,8,9,6,4};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSor(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序，原地排序，时间复杂度O(n*n)，不是稳定排序
     * 比如 5，8，5，2，9 这样一组数据，使用选择排序算法来排序的话，第一次找到最小元素 2，与第一个 5 交换位置,
     * 那第一个 5 和中间的 5 顺序就变了，所以就不稳定了
     * 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕
     * 1.初始时，认为i的位置就是最小值不想，k表示最小值的坐标
     * 2.如果J 位置的值小 K位置的值，则交换
     * 3.每次内循环完后,比较i和k的值，i!=k ,交换位置
     */
    private void selectSor(int []arr){
        for (int i = 0; i < arr.length; i++) {
            int k = i; //1.初始时，认为i的位置就是最小值不想，k表示最小值的坐标
           for(int j = k + 1; j < arr.length ; j++){
               if(arr[j] < arr[k]){
                   //2.如果J 位置的值小 K位置的值，则交换
                   k = j;
               }
           }
           //3.每次内循环完后,比较i和k的值，i!=k ,交换位置
            if(i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }
}
