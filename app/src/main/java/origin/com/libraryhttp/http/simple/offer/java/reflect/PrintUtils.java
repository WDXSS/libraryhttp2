package origin.com.libraryhttp.http.simple.offer.java.reflect;

import java.util.List;
/**
 * @author meitu.xujun  on 2017/3/28 16:49
 * @version 0.1
 */

public class PrintUtils {

    public static  final String TAG="xujun";

    public static void print(Object o){
    	System.out.println("print:" +o);
      
    }

    public static void print(Object[] os){
        for(Object o:os){
            System.out.println( "print: " +o);
        }

    }

    public static void print(List<Object> objectList){
        for(Object o:objectList){
            System.out.println( "print:" +o);
        }

    }
}
