package com.example.process;

import com.example.annotations.BindView;
import com.google.auto.service.AutoService;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class ClassProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //TODO 必须指定的方法，指定注解处理器是注册给那个注解的
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        //TODO 用来指定使用的java版本
        return super.getSupportedSourceVersion();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //TODO 相当于main();扫描，评估，处理注解代码,生成java文件

        Messager messager = processingEnv.getMessager();
        for (Element element : roundEnvironment.getElementsAnnotatedWith(BindView.class)) {
            if (element.getKind() == ElementKind.FIELD) {
                //打印注解修饰的成员变量名词
                messager.printMessage(Diagnostic.Kind.NOTE,"printMessage :"+element.toString());
            }
        }

        return false;
    }
}
