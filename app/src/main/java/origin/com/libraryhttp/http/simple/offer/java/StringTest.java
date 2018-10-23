package origin.com.libraryhttp.http.simple.offer.java;

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

        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);//false
        System.out.println(b.intern() == c);//true
        System.out.println(b.intern() == d);//true
        System.out.println(b.intern() == f);//false
        System.out.println(b.intern() == a.intern());//true
        System.out.println(c.intern() == d);//true


    }

    private void stringIntern(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");
        System.out.println("str4 = "+ str4.intern());
        System.out.println("str5 = "+ str5.intern());

        System.out.println(str5.equals(str3));//true
        System.out.println(str5 == str3);//false;
        System.out.println(str5.intern() == str3);//true
        System.out.println(str5.intern() == str4);//false; 含有变量则不会进入字符串池中
    }
}
