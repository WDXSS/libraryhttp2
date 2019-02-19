package origin.com.libraryhttp.http.simple.offer.algorithm;

import java.util.Arrays;

/**
 * 算法学习
 * 1.冒泡
 * 2.快速
 * 3.插入排序
 * 4.归并排序
 * Created by zc on 2018/10/8
 */
public class AlgorithmJava {
    private int[] bubbleA = {99, 54, 1, 3, 58, 46, 8, 61, 9, 2};
    private static int[] quickSortA = {9, 54, 1, 3, 58, 46, 8, 61, 9, 2};
    private int insertA[] = {3, 2, 1, 5, 5, 3, 6};
    private int mergeA[] = {4,3,2,8,7,6};
    private int mergeTemp[] = new int[mergeA.length];//归并排序中过渡数组

    public static void main(String[] args) {
        AlgorithmJava algorithmJava = new AlgorithmJava();
//        algorithmJava.bubbleSort();
//        algorithmJava.bubbleSortB();
//        algorithmJava.quickSort(0, quickSortA.length - 1);
//        algorithmJava.quickSortTest(0, quickSortA.length - 1);
//        algorithmJava.insertSort();

        algorithmJava.mergeSort(0, algorithmJava.mergeA.length -1);
        //合并两个数组
//        algorithmJava.mergeArray();
    }

    /**
     * 1.快速排序 <br/>
     * 快速排序（QuickSort）是对冒泡排序的一种改进。 <br/>
     * 基本思想是：通过一趟排序将要排序的数据分割成独立的两个部分。 <br/>
     * 其中一部分的所有数据都比另外一部分的所有数据都要小， <br/>
     * 然后再按此方法对这两部分数据分别进行快速排序 <br/>
     * 整个过程可以递归进行， <br/>
     * 博客介绍 ：http://developer.51cto.com/art/201403/430986.htm <br/>
     * 0.取对比数 temp
     * 1.从右往左找小的数 (顺序很重要，先从右往左找小于temp的，j停止的时候一定是个比temp小的数，
     * 复位时a[0]一定是个比temp小的数，测试方法{@link #quickSortTest(int, int)} 1和2调换位置)
     * 2.从左往右找大的数
     * 3.交换位置
     * 循环完毕后对比数复位
     * <p>
     * 左右递归
     */
    private void quickSort(int left, int right) {
        System.out.println("left = " + left + ",right =" + right);
        if (left >= right) {
            return;
        }
        int temp = quickSortA[left];//中间数
        int i = left;
        int j = right;

        while (i != j) {
            while (quickSortA[j] >= temp && i < j) {//1.从右往左找到小于temp的值 否则 j--
                System.out.println("j = " + j);
                j--;
            }
            int aJ = quickSortA[j];
            System.out.println("j = " + j + ", aj = " + aJ);

            while (quickSortA[i] <= temp && i < j) {//2.从左往右找到大于temp的值 否则 i++
                System.out.println("i = " + i);
                i++;
            }
            int aI = quickSortA[i];
            System.out.println("i = " + i + ", ai = " + aI);

            printQuickA("交换前");
            if (i < j) { //交换位置
                int m = aI;
                quickSortA[i] = quickSortA[j];
                quickSortA[j] = m;
            }
            printQuickA("交换后");
        }

        //3.基数复位
        quickSortA[left] = quickSortA[i];
        quickSortA[i] = temp;
        printQuickA("基数复位后");

        quickSort(left, i - 1);//继续处理左边的
        quickSort(i + 1, right);//继续处理右边的
    }

    /**
     * 测试步骤1.和2.交换位置出现的问题
     * 复位时会出现，找到的数值比 temp大
     *
     * @param left
     * @param right
     */
    private void quickSortTest(int left, int right) {
        int temp = quickSortA[left];//中间数
        int i = left;
        int j = right;

        while (i != j) {
            while (quickSortA[i] <= temp && i < j) {//2.从左往右找到大于temp的值 否则 i++
                System.out.println("i = " + i);
                i++;
            }
            int aI = quickSortA[i];
            System.out.println("i = " + i + ", ai = " + aI);


            while (quickSortA[j] >= temp && i < j) {//1.从右往左找到小于temp的值 否则 j--
                System.out.println("j = " + j);
                j--;
            }
            int aJ = quickSortA[j];
            System.out.println("j = " + j + ", aj = " + aJ);

            printQuickA("交换前");
            if (i < j) { //交换位置
                int m = aI;
                quickSortA[i] = quickSortA[j];
                quickSortA[j] = m;
            }
            printQuickA("交换后");
        }

        //3.基数复位
        quickSortA[left] = quickSortA[i];
        quickSortA[i] = temp;
        printQuickA("基数复位后");
    }

    /**
     * 2.冒泡排序(BubbleSort)<br/>
     * bubbleSort 是一种计算机科学领域比较简单的排序算法 <br/>
     * 原理：每次比较相邻的元素，错误交换位置 <br/>
     * 博客介绍：http://blog.51cto.com/ahalei/1364401 <br/>
     * 1.创建一个外循环i
     * 2.创建一个内循环j；  bubbleA.length - 1 - i减i的原因：i循环完一次后 最大值已经在最顶端
     * 3.比较两相邻的数 A[j] 和 A[j+1]
     * 4.交换位置
     */
    private void bubbleSortB() {
        printQuickA("");
        System.out.println("开始排序");
        for (int i = 0; i < bubbleA.length - 1; i++) {//1.创建一个外部循环
            for (int j = 0; j < bubbleA.length - 1 - i; j++) {//2.创建一个内循环，减i的原因：i循环完一次后 最大值已经在最顶端
                if (bubbleA[j] > bubbleA[j + 1]) { //3.相邻两个数据进行对比
                    //4.交换位置
                    int temp = bubbleA[j];
                    bubbleA[j] = bubbleA[j + 1];
                    bubbleA[j + 1] = temp;
                    printBubbleA("交换后 ");
                }
            }
        }
    }


    /**
     * 插入排序 原地，稳定排序
     * <p>
     * 1.元素移动过位置 j--j+1
     * 2.temp 插入到合适位置
     * 3.注意内循环的终止条件
     */
    private void insertSort() {
        int i, j;
        for (i = 1; i < insertA.length; i++) {
            int temp = insertA[i];
            System.out.println("要插入的数据 " + temp);
            for (j = i - 1; j >= 0; j--) {
                //if (insertA[j] > temp) 从小到大
                //if (insertA[j] < temp) 从大到小
                if (insertA[j] > temp) {//认为 0到j是有序的，如果temp<[j]---[j]移动位置到j+1
                    insertA[j + 1] = insertA[j];
                } else {
                    break;//一定要有break，内循环的终止条件是 j>=0,将会循环到j=0
                }
            }
            /**
             * 插入temp
             */
            insertA[j + 1] = temp;
            printInsertA("第" + i + "ci -");
        }
    }


    /**
     * 归并排序（Merge sort）
     * 1.拆分，以数组长度的中间值，即 mid = （left + right）/ 2
     * 2.合并{@link #merge(int, int, int)}
     * 3.讲temp中的数据复制到a[]中，这里注意点：不是将所有的数据都排好序，然后放入a[]
     * 4. mergeSort 是递归会将left 和 right的值从大到小一层一层的剥离，
     *   而merge()方法会因为 mergeSort的递归 left和right的值从小到大，一层一层的增加
     */
    private void mergeSort(int left, int right) {
        System.out.println("left = [" + left + "], right = [" + right + "]");
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        System.out.println("mid = " + mid);
        System.out.println("mergeA = "+ Arrays.toString(mergeA));
        System.out.println("mergeTemp = "+ Arrays.toString(mergeTemp));

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, right, mid);

    }

    /**
     * 合并，left，right，mid 会随着递归，一层层增大
     */
    private void merge(int left, int right, int mid) {
//        System.out.println("merge -- left = " + left + ", right = " + right + ",mid = " + mid);
        int i = left;//第一个数组的开始位置，mid结束位置
        int m = mid + 1;//第二个数组中的开始位置
        int j = right;//第二个数组的结束位置
        int tempI = 0;
        //拆分成 i--mid和 m -- j；的两数组
        //比较两数组的大小，将两个数组中数据存入到temp中
        System.out.println("merge ---left = [" + left + "], right = [" + right + "], mid = [" + mid + "]");
        while (i <= mid && m <= j) {
            if (mergeA[i] < mergeA[m]) {
                mergeTemp[tempI++] = mergeA[i++];
            } else {
                mergeTemp[tempI++] = mergeA[m++];
            }
        }
        while (i <= mid) {
            mergeTemp[tempI++] = mergeA[i++];
        }
        while (m <= j) {
            mergeTemp[tempI++] = mergeA[m++];
        }
        System.out.println("merge --- temp = "+ Arrays.toString(mergeTemp));
        tempI = 0;
        //将temp中的元素拷贝到原数组中
        while(left <= right){
            System.out.println("while before merge -- arr = "+ Arrays.toString(mergeA));
            System.out.println("while before merge -- temp = "+ Arrays.toString(mergeTemp));
            mergeA[left++] = mergeTemp[tempI++];
            System.out.println("while after merge -- arr = "+ Arrays.toString(mergeA));
            System.out.println("while after merge -- temp = "+ Arrays.toString(mergeTemp));
        }
    }


    /**
     * 两个有序数组合并成一个数组
     * 注意是有序的数组
     */
    private void mergeArray() {
        int a[] = {1, 3, 5};
        int b[] = {2, 4, 6, 8, 10};
        int c[] = new int[a.length + b.length];
        System.out.println(Arrays.toString(c));
        printC(c);
        System.out.println(Arrays.toString(c));
        int ai = 0;
        int bi = 0;
        int ci = 0;

        while (ai < a.length && bi <= b.length) {
            int at = a[ai];
            int bt = b[bi];
            if (at < bt) {
                c[ci] = a[ai];
                ai++;
            } else {
                c[ci] = b[bi];
                bi++;
            }
            ci++;
            System.out.println("bi = " + bi + ", ai = " + ai);
            printC(c);
        }
        //讲a[] 或者B数组中剩余的数据取出放入到 c[]中
        System.out.println("将数组a或者数组B 中剩余的数据放入到 数组C中");
        while (ai < a.length) {
            c[ci] = a[ai];
            ai++;
            ci++;
            //c[ci] = a[ai];ai++;  ci++;简单写法 c[ci ++]= a[ai ++]
            printC(c);
        }
        while (bi < b.length) {
            c[ci] = b[bi];
            bi++;
            ci++;
            printC(c);
        }
    }

    private void printC(int c[]) {
        System.out.print("temp -- ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + ",");
        }

        System.out.println();

    }

    /**
     * 队列 博客介绍：http://blog.51cto.com/ahalei/1371613 <br/>
     * 栈 博客介绍:http://blog.51cto.com/ahalei/1377872 <br/>
     */
    private void printQuickA(String name) {
        System.out.println(name + "--" + "");
        for (int i = 0; i < quickSortA.length; i++) {
            System.out.print(quickSortA[i] + ",");
        }
        System.out.println("");
    }

    private void printBubbleA(String name) {
        System.out.println(name + "--" + "");
        for (int i = 0; i < bubbleA.length; i++) {
            System.out.print(bubbleA[i] + ",");
        }
    }

    private void printInsertA(String name) {
        System.out.println(name + "--" + "");
        for (int i = 0; i < insertA.length; i++) {
            System.out.print(insertA[i] + ",");
        }
        System.out.println();
    }
}
