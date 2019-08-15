package origin.com.libraryhttp.http.simple.offer.annotation;

/**
 * 运行时注解
 */
public class AnnotationMainV2 {

    //1.新建 Java Library 来存放注解， 命名为annotations
    //1.2 创建注解类 BindView

    //2 新建java Library 来存放注解处理器， 命名为 process
    // 2.2 配置 build.gradle 添加依赖的 annotations
    //-----配置java的编译版本
    //2.3 创建注解处理器 ClassProcessor
    //2.4 创建服务文件注册注解处理器：
    //-----process 库的 main目录下创建 resources 资源文件夹
    //-----resources 目录下创建 META-INF/services 文件夹 创建 javax.annotation.processing.Processor 文件
    //-----文件内容是注解处理器的名词 如：com.example.process.ClassProcessor

    //2.4 创建服务文件注册注解处理器:
    //----可以通过Google 开源的AutoService来创建文件
    //----在build.gradle z中添加依赖
    //---- 注解处理器中添加 @AutoService(Processor.class)

    //2.5 在app中使用 BindView注解

}
