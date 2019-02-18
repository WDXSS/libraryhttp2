package origin.com.libraryhttp.http.simple.offer.algorithm;

/**
 * 算法学习
 * Created by zc on 2018/10/8
 */
public class AlgorithmJava {
    private int[] bubbleA = {99, 54, 1, 3, 58, 46, 8, 61, 9, 2};
    private static int[] quickSortA = {9, 54, 1, 3, 58, 46, 8, 61, 9, 2};

    public static void main(String[] args) {
        AlgorithmJava algorithmJava = new AlgorithmJava();
//        algorithmJava.bubbleSort();
//        algorithmJava.bubbleSortB();
//        algorithmJava.quickSort(0, quickSortA.length - 1);
//        algorithmJava.quickSortTest(0, quickSortA.length - 1);
        algorithmJava.insertSort();
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

    int insertA[] = {3, 2, 1, 5, 5, 3, 6};

    /**
     * 插入排序 原地，稳定排序
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
