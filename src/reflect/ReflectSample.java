package src.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 张启磊 on 2019-4-17.
 */
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取类
        Class  c= Class.forName("src.reflect.Cat");
        //创建实例对象
        Cat cat = (Cat) c.newInstance();
        //先获取私有的方法：getDeclaredMethod可以获取该类的 所有方法，但是不能获取基础的方法或者该类实现的方法
        Method sayHi =c.getDeclaredMethod("sayHi",String.class);
        //设置为可进入（私有方法）
        sayHi.setAccessible(true);
        //传入参数
        String s = (String )sayHi.invoke(cat, "果冻");
        System.out.println(s);
        //获取公有方法：getMethod()获取共有方法及其继承方法
        Method getName = c.getMethod("getName");
        //获取私有属性
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(cat,"guodong");
        getName.invoke(cat);
    }
}
