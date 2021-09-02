package test.date210902;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: DataStructures
 * @description: HashMap测试常用方法
 * @author: 谢荣旺 1429382875@qq.com
 * @create: 2021-09-02 17:08
 **/
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        //键不能重复，值可以重复
        map.put("san","张三");
        map.put("si","李四");
        map.put("wu","王五");
        map.put("wang","老王");
        map.put("wang","老王二");
        map.put("lao","老王二");
        System.out.println("--------直接输出hashmap----------");
        System.out.println(map);
        /**
         * 遍历HashMap
         */
        //1、获取所有的key
        System.out.println("--------foreach获取map中所有的键-----------");
        Set<String> keys = map.keySet();
        for (String key :
                keys) {
            System.out.print(key+ " ");
        }
        //换行
        System.out.println();
        //2、获取所有的值
        System.out.println("--------foreach获取map中所有的值-----------");
        Collection<String> values = map.values();
        for (String value:
             values) {
            System.out.print(value+ " ");
        }
        //换行
        System.out.println();
        //3、得到key的值的同时得到key所对应的值
        System.out.println("--------得到key的值的同时得到key所对应的值---------");
        Set<String> keys2 = map.keySet();
        for (String key :
                keys2) {
            System.out.print(key+ ":"+map.get(key)+" ");
        }
        //换行
        System.out.println();
        /**
         * 如果既要遍历key又要获取value，那么建议用这种方式，因为如果先获取keySet然后再执行map.get(key)，map内部会执行两次遍历
         * 一次是在获取keySet时，一次是在获取key对应的value的时候
         */
        /**
         * 当调用put(key,value)的时候，首先会把key和value封装到Entry这个静态内部类对象中，把Entry对象再添加到数组中，所以我们想获取map中所有的键值对
         * 只需要获取数组中所有的Entry对象，接下来调用Entry对象的GetKey()和GetValue()方法就能获取到键值对了
         */
        Set<Map.Entry<String,String>> entries = map.entrySet();
        for (Map.Entry entry:entries) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

        /**
         * 其他常用方法
         */
        System.out.println("after ma.size():"+map.size());
        System.out.println("after ma.isEmpty():"+map.isEmpty());
        map.remove("san");
        System.out.println("after ma.remove():"+map);
        System.out.println("after ma.get(si):"+map.get("si"));
        System.out.println("after map.containsKey(si)："+map.containsKey("si"));
        System.out.println("after containsValue(李四)："+map.containsValue("李四"));
        System.out.println(map.replace("si", "李四2"));
        System.out.println("after map.replace(si, 李四2):"+map);
    }
}
