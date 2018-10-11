package origin.com.libraryhttp.http.simple.offer;

/**
 * String StringBuffer StringBuilder 的区别
 * Created by zc on 2018/10/11
 */
public class StringTest {
    public static void main(String[] args) {
        String string1 = "";
//        StringBuilder stringBuilder1 = "";//报错
        String string = null;
        StringBuffer stringBuffer = null;
        StringBuilder stringBuilder = null;
        string = string +"string";
        stringBuffer.append("stringBuffer");//stringBuffer.NullPointerException
        stringBuilder.append("stringBuilder");//stringBuilder.NullPointerException
        System.out.println(string);
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);

    }
}
