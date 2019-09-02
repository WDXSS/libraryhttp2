package origin.com.libraryhttp.http.simple.offer.java.enum1;

/**
 * https://www.cnblogs.com/hyl8218/p/5088287.html
 * <p>
 * 创建枚举类型要使用 enum 关键字，隐含了所创建的类型都是
 * java.lang.Enum 类的子类（java.lang.Enum 是一个抽象类）。
 * 枚举类型符合通用模式 Class Enum<E extends Enum<E>>，
 * 而 E 表示枚举类型的名称。
 * 枚举类型的每一个值都将映射到 protected Enum(String name, int ordinal) 构造函数中，
 * 在这里，每个值的名称都被转换成一个字符串，并且序数设置表示了此设置被创建的顺序
 */
public class EnumMain {
    public static void main(String[] args) {
//        for (EnumTest e : EnumTest.values()) {
//            System.out.println(e.toString());
//        }

        for (EnumTest2 e : EnumTest2.values()) {
            System.out.println(e.toString());
            System.out.println("EnumTest 的 value = " + e.getValue());
        }
        System.out.println("EnumTest.FRI 的 value = " + EnumTest2.FRI.getValue());
    }


}
//TODO 常用方法
//
//        int compareTo(E o)
//          比较此枚举与指定对象的顺序。
//
//         Class<E> getDeclaringClass()
//        返回与此枚举常量的枚举类型相对应的 Class 对象。
//
//        String name()
//        返回此枚举常量的名称，在其枚举声明中对其进行声明。
//
//        int ordinal()
//        返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
//
//        String toString()
//
//        返回枚举常量的名称，它包含在声明中。
//
//        static <T extends Enum<T>> T valueOf(Class<T> enumType, String name)
//        返回带指定名称的指定枚举类型的枚举常量。