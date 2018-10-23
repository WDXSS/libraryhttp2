package origin.com.libraryhttp.http.simple.offer.java.reflect;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author meitu.xujun  on 2017/3/28 16:17
 * @version 0.1
 */

public class TestHelper {

    public static final String TAG = "xujun";
    public static final String CLASS_NAME = "origin.com.libraryhttp.http.simple.offer.java.reflect.Person";
    public static final String CHINA = "China";

    public static void testConstructor() {
        //打印构造方法：包括私有的，非私有的
        ReflectHelper.printConstructor(CLASS_NAME);
        //获取特定的构造方法
        Constructor constructor = ReflectHelper.getConstructor(CLASS_NAME, String.class, Integer.class);
        try {
            //创建对象
            Object meinv = constructor.newInstance(CHINA, 12);
            Person person = (Person) meinv;
            System.out.println("testConstructor: =" + person.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void testMethod() {
        ReflectHelper.printMethods(CLASS_NAME);
        Person person = new Person();
        //获取指定的方法
        Method method = ReflectHelper.getMethod(CLASS_NAME,
                "setCountry", String.class);
        try {
            // 执行方法，结果保存在 person 中
            Object o = method.invoke(person, CHINA);//传入入参，得到返回值，
            // 拿到我们传递进取的参数 country 的值 China
            String country = person.country;
            PrintUtils.print(country);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void testFiled() {
        ReflectHelper.printFields(CLASS_NAME);
        Person person = new Person(CHINA, 12);
        Field field = ReflectHelper.getFiled(CLASS_NAME, "age");
        try {
            //得到变量的值
            Integer integer = (Integer) field.get(person);
            PrintUtils.print("integer=" + integer);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 利用反射操作数组
     * 1 利用反射修改数组中的元素
     * 2 利用反射获取数组中的每个元素
     */
    public static void testArrayClass() {
        String[] strArray = new String[]{"5", "7", "暑期", "美女", "女生", "女神"};
        Array.set(strArray, 0, "帅哥");
        Class clazz = strArray.getClass();
        if (clazz.isArray()) {
            int length = Array.getLength(strArray);
            for (int i = 0; i < length; i++) {
                Object object = Array.get(strArray, i);
                String className = object.getClass().getName();
                System.out.println("----> object=" + object + ",className=" + className);
            }
        }
    }

    public static void getGenericHelper(HashMap<String, Person> map) {

    }

    public static void getGenericType() {
        try {
            Method method = TestHelper.class.getDeclaredMethod("getGenericHelper", HashMap.class);
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            // 检验是否为空
            if (null == genericParameterTypes || genericParameterTypes.length < 1) {
                return;
            }
            // 取 getGenericHelper 方法的第一个参数

            ParameterizedType parameterizedType = (ParameterizedType) genericParameterTypes[0];
            Type rawType = parameterizedType.getRawType();
            System.out.println("----> rawType=" + rawType);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments == genericParameterTypes || actualTypeArguments.length < 1) {
                return;
            }
            //  打印出每一个类型          
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type = actualTypeArguments[i];
                System.out.println("----> type=" + type);
            }
        } catch (Exception e) {

        }

    }
}
