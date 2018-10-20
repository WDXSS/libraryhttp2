package origin.com.libraryhttp.http.simple.offer;

/**
 * String StringBuffer StringBuilder 的区别
 * Created by zc on 2018/10/11
 */
public class StringTest {
    public static void main(String[] args) {
//        String string1 = "";
////        StringBuilder stringBuilder1 = "";//报错
//        String string = null;
//        StringBuffer stringBuffer = null;
//        StringBuilder stringBuilder = null;
//        string = string +"string";
//        stringBuffer.append("stringBuffer");//stringBuffer.NullPointerException
//        stringBuilder.append("stringBuilder");//stringBuilder.NullPointerException
//        System.out.println(string);
//        System.out.println(stringBuffer);
//        System.out.println(stringBuilder);

        //深入理解String
        String str1 = "c";
        String str2 = "c";
        System.out.println("== "+ (str1 == str2 ));//结果：true; 字符串常量池

        String s1 = new String("chao");
        String s2 = new String("chao");

        System.out.println("hasCode s1= "+ s1.hashCode());//hashCode 相同，
        System.out.println("hasCode s2= "+ s2.hashCode());
        System.out.println("equals = "+ s2.equals(s1) );//结果：true ：原因--s1和s2 是不同的对象，因为String重写了 equals();比较的是真实的值
        System.out.println("== "+ (s1 == s2 ));//结果：false;

        StringTest test = new StringTest();
        Cat cat1 = test.new Cat(1);
        Cat cat2 = test.new Cat(1);
        System.out.println("----------------------");
        System.out.println("hasCode cat1= "+ cat1.hashCode());
        System.out.println("hasCode cat2= "+ cat2.hashCode());
        System.out.println("equals = "+ cat2.equals(cat1) );
        System.out.println("== "+ (cat2 == cat1 ));

        //总结：
        // 1.String 类 被final修饰不可修改，不可继承，
        // 2.String重写了 equals();比较的是真实的值
        // 3.字符串常量池

    }

    class Cat {
        int age;
        public Cat(int age) {
            this.age = age;
        }
    }

}
