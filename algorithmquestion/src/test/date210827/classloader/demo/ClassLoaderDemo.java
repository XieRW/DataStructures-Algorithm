package test.date210827.classloader.demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: DataStructures
 * @description: 测试自定义类加载器
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-28 22:30
 **/
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader_1 classLoader_1 = new MyClassLoader_1(ClassLoaderDemo.class.getClassLoader());
        MyClassLoader_2 classLoader_2 = new MyClassLoader_2(classLoader_1);
        System.out.println(classLoader_2);
        Class classB = classLoader_2.loadClass("test.date210827.classloader.bc.ClassB");
        Object classBInstance = classB.newInstance();
        Method method = classB.getMethod("method");
        method.invoke(classBInstance);
    }

}


