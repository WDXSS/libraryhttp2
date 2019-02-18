package origin.com.libraryhttp.http.simple.offer.algorithm;

import java.util.Arrays;

/**
 * Created by zc on 2019/2/18
 */
public class MergeSort {
    public static void main(String []args){
//        int []arr = {9,8,7,6,5,4,3,2,1};
        int []arr = {4,3,6,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        System.out.println("arr = "+ Arrays.toString(arr));
        System.out.println("temp = "+ Arrays.toString(temp));
        System.out.println("left = [" + left + "], right = [" + right + "]");
        if(left<right){
            int mid = (left+right)/2;

            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序

            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            System.out.println("swap while merge -- temp = "+ Arrays.toString(temp));
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        System.out.println("merge -- left = [" + left + "], mid = [" + mid + "], right = [" + right + "]");
        System.out.println("merge -- temp = "+ Arrays.toString(temp));
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
            System.out.println("while merge -- arr = "+ Arrays.toString(arr));
            System.out.println("while merge -- temp = "+ Arrays.toString(temp));
        }
    }
}
