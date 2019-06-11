package origin.com.libraryhttp.http.simple.offer.java.reflect.v2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a class.
 * This program uses reflection to print all feature of a class.
 *
 * 例如：输入： java.lang.Double
 * Created by zc on 2019/5/2
 */
public class ReflectionTest {

    public static void main(String[] args) {
        //read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g.java.util.Date):");
            name = in.next();
        }


        try {
            //print class name and superclass name (if != Object)
            Class cl = Class.forName(name);
            Class super1 = cl.getSuperclass();
            //得到修饰符
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class" + name);

            if(super1 != null && super1 != Object.class){
                System.out.print(" extends " + super1.getName());
            }
            System.out.print("{\n");
            System.out.println();
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * print all constructors of a class
     * @param cl cl a class
     */
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");

            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers +" ");
            }
            System.out.print(name + "(");

            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all methods of a class
     * @param cl cl a class
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name = method.getName();
            System.out.print("   ");

            //print modifiers, return type and method name
            String modifiers = Modifier.toString(method.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            //print parameter types
            Class[] parameter  = method.getParameterTypes();
            for (int i = 0; i < parameter.length; i++) {
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(parameter[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * prints all fields of a class
     * @param cl cl a class
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }

    }

}
