package test.date210827.classloader.a;

import test.date210827.classloader.bc.ClassC;

/**
 * 将该类Class文件放在 D:\temp\a\segmentfault\Question1010000017720845目录下
 */
public class ClassA {

    public void method(ClassC c) {
        System.out.println("调用ClassA.method()");
        System.out.println(c);
        System.out.println(this);
        ClassC c1 = new ClassC();
        //打印的是ClassB和ClassC的加载器 segmentfault.Question1010000017720845.MyClassLoader_2@23fc625e
        System.out.println(c.getClass().getClassLoader());
        try {
            //会用AppClassLoader
            Class classC = this.getClass().getClassLoader().loadClass("test.date210827.classloader.bc.ClassC");
            Class classC2 = this.getClass().getClassLoader().loadClass("test.date210827.classloader.bc.ClassC");
        } catch (ClassNotFoundException e) {
            System.out.println("classC not found");
        }

    }
}
