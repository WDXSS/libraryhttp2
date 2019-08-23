package origin.com.libraryhttp.http.simple.offer.java.generic;

import java.util.ArrayList;

/**
 * Created by zc on 2019/6/11
 */
public class GenericMain {

// https://blog.csdn.net/jeffleo/article/details/52250948
//    https://blog.csdn.net/yangguanghaozi/article/details/54632477
    /**
     * 理解：
     * 上界 <? extend Fruit>
     * 下界 <? super Apple>
     *
     */
//    上界 <? extend Fruit> ，表示所有继承Fruit的子类，但是具体是哪个子类，无法确定，
//    所以调用add的时候，要add什么类型，谁也不知道。
//    但是get的时候，不管是什么子类，不管追溯多少辈，肯定有个父类是Fruit，
//    所以，我都可以用最大的父类Fruit接着，也就是把所有的子类向上转型为Fruit。
//
//    下界 <? super Apple>，表示Apple的所有父类，包括Fruit，一直可以追溯到老祖宗Object 。
//    那么当我add的时候，我不能add Apple的父类，因为不能确定List里面存放的到底是哪个父类。
//    但是我可以add Apple及其子类。因为不管我的子类是什么类型，
//    它都可以向上转型为Apple及其所有的父类甚至转型为Object 。
//    但是当我get的时候，Apple的父类这么多，我用什么接着呢，除了Object，其他的都接不住。

//2.上界和下界的特点
//    上界的list只能get，不能add（确切地说不能add出除null之外的对象，包括Object）
//    下界的list只能add，不能get

//3. 理解擦除
//    Class a = new ArrayList<Integer>().getClass();
//    Class b = new ArrayList<String>().getClass();
//
//    System.out.println(a == b);//输出结果true
}
