package test.date210822;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: DataStructures
 * @description: 测试hashmap的自适应初始化容量
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-08-22 23:54
 **/
public class main4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int n = 100000;
        Long s1 = System.currentTimeMillis();
        Map<Integer,Integer> map1 = new HashMap<>(17);
        Class<?> mapType = map1.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map1));
        for (int i = 0; i < n; i++) {
            map1.put(i,i);
        }
        Long s2 = System.currentTimeMillis();
        System.out.println("耗时："+(s2-s1));

//        Long s3 = System.currentTimeMillis();
//        Map<Integer,Integer> map2 = new HashMap<>(n/2);
//        for (int i = 0; i < n; i++) {
//            map2.put(i,i);
//        }
//        Long s4 = System.currentTimeMillis();
//        System.out.println(s4-s3);
//
//        Long s5 = System.currentTimeMillis();
//        Map<Integer,Integer> map3 = new HashMap<>(n);
//        for (int i = 0; i < n; i++) {
//            map3.put(i,i);
//        }
//        Long s6 = System.currentTimeMillis();
//        System.out.println(s6-s5);

    }
}
