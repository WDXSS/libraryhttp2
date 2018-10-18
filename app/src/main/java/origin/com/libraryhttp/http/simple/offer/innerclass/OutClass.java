package origin.com.libraryhttp.http.simple.offer.innerclass;

/**
 * 成员内部类 <br/>
 * <p>
 * Created by zc on 2018/10/18
 */
public class OutClass {
    private String sameStr = "OutClass.this.sameStr";
    private String outStr = "this.outStr";

    private String outMethod() {
        return "outClass.outMethod()";
    }

    public void printInnerClass() {
        System.out.println("一、成员内部类总结如下：");
        OutClass.InnerClass innerClass = new InnerClass();
        innerClass.innerMethod("成员内部类");
        System.out.println("二、局部内部类总结如下：");
        partClass();

        System.out.println("三、匿名内部类：");
        System.out.println(printAnonymity("匿名内部类").method());

        System.out.println("四、静态内部类：");
        OutClass.InnerStaticClass innerStaticClass = new InnerStaticClass();
        innerStaticClass.staticClassMethod();

        System.out.println("优点总结：");
        System.out.println("1.非静态内部类，默认持有外部类的引用");
        System.out.println("2.多重继承");
    }

    //成员内部类
    public class InnerClass {
        private String innerStr;
        private String sameStr = "this.sameStr";

        //        private static String staticString ="";//成员内部类不能存在static 的变量和方法；
        private void innerMethod(String str) {
            System.out.println(str);
            System.out.println("1.内部类直接访问非同名外部类的成员 = " + outStr);
            System.out.println("2.内部类直接访问外部类的方法 " + outMethod());
            System.out.println("3.访问相同名称的InnerClass变量：" + this.sameStr);
            System.out.println("4.访问相同名称的outClass变量：" + OutClass.this.sameStr);
            System.out.println("5.创建new InnerClass ,需要先new OutClass");
            System.out.println("6.成员内部类不能存在static 的变量和方法");
        }
    }

    //局部内部类
    private void partClass() {
        String sameStr = "this.sameStr - method";
        class PartClass {
            private String partStr = "局部内容部类注意：3和4";
            private String sameStr = "this.sameStr";

            //            private static String staticString ="";//成员内部类不能存在static 的变量和方法；
            private void partClassMethod(String str) {
                System.out.println(str);
                System.out.println("" + partStr);
                System.out.println("1.可以访问 外部类的变量 ：" + OutClass.this.sameStr);
                System.out.println("2.可以访问 外部类的方法 ：" + outMethod());
                System.out.println("3.局部内部类的作用域 ：声明的方法中 ");
                System.out.println("4.成员内部类不能存在static 的变量和方法");
            }
        }
        PartClass partClass = new PartClass();
        partClass.partClassMethod("局部内部类");
        String name = partClass.partStr;
        System.out.println(name);
    }

    //匿名内部类
    private AnonymityClass printAnonymity(final String str) {
        return new AnonymityClass() {
            @Override
            String method() {
                System.out.println(str);
                System.out.println("1.匿名内部类形参是final 的 ");
                System.out.println("2.可以访问 外部类的变量 =" + outStr);
                System.out.println("3.可以访问 外部类的方法 =" + OutClass.this.outMethod());
                System.out.println("4.局部内部类的作用域 ：声明的方法中 ");
                System.out.println("5.匿名内部类不能存在static 的变量和方法");
                return "";
            }
        };
    }

    //静态内部类
    public static class InnerStaticClass {
        private static String str;
        private String someStr;

        private void staticClassMethod() {
            System.out.println("1.不可以访问 外部类的变量 ：OutClass.this.sameStr");
            System.out.println("2.它的创建是不需要依赖于外围类的。");
        }
    }


    abstract class AnonymityClass{
        abstract String method();

    }

}
