package origin.com.libraryhttp.http.simple.offer.annotation;

import origin.com.libraryhttp.http.simple.offer.annotation.example.Apple;
import origin.com.libraryhttp.http.simple.offer.annotation.example.FruitInfoUtil;

/**
 * 注解学习
 * 1.http://www.importnew.com/23564.html
 * 2.https://blog.csdn.net/johnson_moon/article/details/79099285
 * 3.demo ：http://linbinghe.com/2017/ac8515d0.html
 * <p>
 * Created by zc on 2018/10/22
 */
public class AnnotationMain {
    
    public static void main(String[] args) {
//        Student student = new Student("123");
//        student.learnClassAnnotation();
//        System.out.println(student.getName());
//        student.learnFieldAnnotation();

        AnnotationMain annotationMain = new AnnotationMain();
        annotationMain.printApple();
    }

    private void printApple() {
        System.out.println("注解简单实用");
        FruitInfoUtil fruitInfoUtil = new FruitInfoUtil();
        fruitInfoUtil.getFruitInfo(Apple.class);
    }
}
