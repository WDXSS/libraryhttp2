package origin.com.libraryhttp.http.simple.offer.java.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author meitu.xujun  on 2017/3/28 16:08
 * @version 0.1
 */

public class ReflectHelper {

    private static final String TAG = "ReflectHelper";

    public static Method getMethod(String className, String methodName, Class<?>... clzs) {
        try {
            Class<?> aClass = Class.forName(className);
            System.out.println("获取指定的方法--" + methodName);
            Method declaredMethod = aClass.getDeclaredMethod(methodName, clzs);
            declaredMethod.setAccessible(true);
            //start Method,Field,Constructor 的访问权限 （ public,private,ptotected 等）
            int modifier = declaredMethod.getModifiers();
            System.out.println("方法的访问权限 = "+Modifier.toString(modifier));
            //end
            return declaredMethod;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printMethods(String className) {
        try {
            Class<?> aClass = Class.forName(className);
            Method[] methods = aClass.getMethods();
            System.out.println("打印 public 的方法");
            PrintUtils.print(methods);
            Method[] declaredMethods = aClass.getDeclaredMethods();
            System.out.println("打印 所有的方法");
            PrintUtils.print(declaredMethods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Field getFiled(String className, String filedName) {
        Object o = null;
        try {
            Class<?> aClass = Class.forName(className);
            System.out.println("获取指定变量");
            Field declaredField = aClass.getDeclaredField(filedName);
            PrintUtils.print(declaredField);
            //   if not public,you should call this
            declaredField.setAccessible(true);
            return declaredField;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;

    }

    //得到指定的构造方法
    public static Constructor getConstructor(String className, Class<?>... clzs) {
        try {
            Class<?> aClass = Class.forName(className);
            System.out.println("得到指定的构造方法");
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(clzs);
            PrintUtils.print(declaredConstructor);
            //   if Constructor is private,you should set
            declaredConstructor.setAccessible(true);
            return declaredConstructor;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void printConstructor(String className) {
        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println("打印public 的构造方法");
            PrintUtils.print(constructors);
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            System.out.println("打印所有的构造方法");
            PrintUtils.print(declaredConstructors);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printFields(String className) {
        Object o = null;
        try {
            Class<?> aClass = Class.forName(className);
            Field[] fields = aClass.getFields();
            System.out.println("-----打印public 的变量");
            PrintUtils.print(fields);
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println("-----打印全部变量");
            PrintUtils.print(declaredFields);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
