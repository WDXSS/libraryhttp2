package origin.com.libraryhttp.http.simple.offer.java.reflect;

import java.lang.reflect.Constructor;

/**
 * 反射机制:
 *  反射：程序运行时，取得类的构造方法，方法，变量 <br/>
 *  <a href="https://blog.csdn.net/gdutxiaoxu/article/details/68947735">反射机制</a> <br/>
 *  1.反射<1>获取所有的构造方法</>   <br/>
 *    <2>获取指定的构造方法，并且可以创建对象<br/>
 *  2.反射<1>获取所有的变量，所有变量的值<br/>
 *    <2>获取指定的变量，并且可以得到指定变量的值<br/>
 *  3.反射<1>获取所有的方法<br/>
 *    <2>获取指定的方法，修改入参，得到返回值<br/>
 *  4.反射<1>数组<br/>
 *  5.反射<1>获得泛型类型 学习 java Type   <a href="https://blog.csdn.net/gdutxiaoxu/article/details/68926515">java type</a><br/>
 *  6. Method,Field,Constructor 的访问权限 （ public,private,ptotected 等）<br/>
 *     {ReflectHelper.getMethod()}
 */
public class ReflectMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TestHelper.testConstructor();
//		TestHelper.testFiled();
		TestHelper.testMethod();
//		TestHelper.testArrayClass();
//		TestHelper.getGenericType();//泛型

	}

}
