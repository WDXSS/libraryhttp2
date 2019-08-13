package origin.com.libraryhttp.http.simple.offer.java.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 引用类型：
 * 1. 强引用 (Strong Reference)
 * 2. 软引用 SoftReference 内存不足是才会被回收
 * 3. 弱引用 WeakReference 存在弱引用的对象，每次JVM进行垃圾回收时，该对象都会被回收
 * 4. 虚引用 PhantomReference 必须配合 引用队列使用
 *
 * 5. 引用队列（ReferenceQueue）
 */
public class ReferenceMain {

    public static void main(String[] args) {
        ReferenceMain referenceMain = new ReferenceMain();
        referenceMain.strongReference();
        referenceMain.softReference();
        referenceMain.weakReference();
        referenceMain.test_gc2();
    }

    private void strongReference(){
        String str = "Strong Reference ";
    }

    private void softReference(){
        String str = "soft Reference";
        SoftReference<String> softReference = new SoftReference<>(str);
        System.out.println("soft Reference value = " + softReference.get());
    }

    private void weakReference() {
        //引用队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = "weak reference ";
        WeakReference<String> weakReference = new WeakReference<>(str,referenceQueue);
        if (!weakReference.enqueue()) {
            System.out.println("Failed");
        }
        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println("the value is got by reference queue = "+ reference.get());
        System.gc();
        System.out.println("the value is got by reference queue = "+ referenceQueue.poll());
        weakReference.clear();
        System.out.println("Object is: " + str);
        System.out.println("weakReference value is: " + weakReference.get());

    }

    private void test_gc2(){

        String a= new String("wohenhao");

        SoftReference< ?> softReference=new SoftReference(a);

        WeakReference< ?> weakReference=new WeakReference(a);
        System.out.println("强引用："+a+"\n软引用"+softReference.get()+"\n弱引用"+weakReference.get()+"\n");
        a=null;
        System.out.println("强引用："+a+"\n软引用"+softReference.get()+"\n弱引用"+weakReference.get()+"\n");
//        softReference.clear();
        System.gc();
        System.out.println("强引用："+a+"\n软引用"+softReference.get()+"\n弱引用"+weakReference.get()+"\n");
    }
}
