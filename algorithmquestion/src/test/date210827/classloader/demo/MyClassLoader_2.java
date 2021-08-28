package test.date210827.classloader.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 加载ClassB和ClassC
 */
class MyClassLoader_2 extends ClassLoader {
    public MyClassLoader_2(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) {
        String myPath = "" + name.replace(".","/") + ".class";
        System.out.println("classLoader_2 :" + myPath);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(myPath));
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
            System.out.println("找不到资源");
            return null;
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }
}
