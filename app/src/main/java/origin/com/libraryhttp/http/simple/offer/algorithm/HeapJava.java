package origin.com.libraryhttp.http.simple.offer.algorithm;

/**
 * 堆
 * Created by zc on 2018/10/10
 */
public class HeapJava {
    private static int[] heapA = {99, 5, 36, 7, 22, 17, 46, 12, 2, 19, 25, 28, 1, 92};
    private static int[] heapB = {0, 99, 5, 36, 7, 22, 17, 46, 12, 2, 19, 25, 28, 1, 92};
    private String test;
    public static void main(String[] args) {
        HeapJava heapJava = new HeapJava();
//       heapJava.createMaxHeap();
        heapJava.buildMaxHeap(heapA);
//        String string = null;
//        StringBuffer stringBuffer = null;
//        StringBuilder stringBuilder = null;
//        string = string +"string";
//        stringBuffer.append("stringBuffer");//stringBuffer.NullPointerException
//        stringBuilder.append("stringBuilder");//stringBuilder.NullPointerException
//        System.out.println(string);
//        System.out.println(stringBuffer);
//        System.out.println(stringBuilder);

    }

    /**
     * 节点数以 1开始：                                                         1
     * 左节点：2i ；右节点 2i+1;                                             2      3
     * 创建大堆                                                            4  5
     * 1.找到最后一个非叶节点 --节点数: n/2
     * 2.
     */
    private void createMaxHeap() {

        int last = (heapB.length - 1) / 2;
        System.out.println("最后非叶节点 = " + last);
        for (int i = last; i >= 1; i--) {
            siftDown(i);
        }
    }

    /**
     * @param node
     */
    private void siftDown(int node) {//向下筛选
        System.out.println("");
        System.out.println("叶节点 = " + node);
        int nodeB = heapB[node];
        int leftB = heapB[2 * node];//左节点
        int rightB = 0;
        if (2 * node + 1 <= heapB.length - 1) {//判断是否有右节点
            rightB = heapB[2 * node + 1];
        }
        int max = nodeB;
        System.out.println("nodeB = " + nodeB + ",leftB= " + leftB + ",rightB = " + rightB + ",max = " + max);
        printHeapB();
        System.out.println("");
        int flag = 0;
        //比较大小
        if (max < leftB) {
            heapB[node] = heapB[2 * node];
            heapB[2 * node] = max;
            max = heapB[node];

        }
        if (max < rightB) {
            heapB[node] = heapB[2 * node + 1];
            heapB[2 * node + 1] = max;
            max = heapB[node];
        }
        printHeapB();

        //
    }

    private void printHeapB() {
        for (int i = 0; i <= heapB.length - 1; i++) {
            System.out.print(" " + heapB[i]);
        }
    }

    //构建大根堆：将array看成完全二叉树的顺序存储结构
    private int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }

    //将元素array[k]自下往上逐步调整树形结构
    private void adjustDownToUp(int[] array, int k, int length) {
        System.out.println("");
        System.out.println("节点 = " + k + ", length = " + length);
        int temp = array[k];
        printHeapA();
        System.out.println("");
        System.out.println("temp = " + temp);
//        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k + 1; i <= length - 1; i = 2 * i + 1) {
            System.out.println("i = " + i);
            System.out.println("array[k] = " + array[k]);
            System.out.println("array[i] = " + array[i]);
            if (i + 1 <= length - 1) {
                System.out.println("array[i + 1] = " + array[i + 1]);
            }
//            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
            if (i + 1 < length && array[i] < array[i + 1]) {
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
        printHeapA();
    }

    private void printHeapA() {
        for (int i = 0; i <= heapA.length - 1; i++) {
            System.out.print(" " + heapA[i]);
        }
    }
}


























