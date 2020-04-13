package src.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by 26725 on 2019/4/18.
 */
public class Test {
    public static void main(String[] args) {
        /**
         *  一,获取类的class对象的3种方法,
         */
        ReflectTest reflectTest = new ReflectTest();
        Class<? extends ReflectTest> aClass1 = reflectTest.getClass();

        Class<ReflectTest> aClass2 = ReflectTest.class;
        System.out.println(aClass1 == aClass2);
        Class<?> aClass3 = null;
        try {
             aClass3 = Class.forName("src.reflect.ReflectTest");
            System.out.println(aClass2 == aClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * 通过比较得出结论：通过3种方法得到的Class对象是同一个，即一个类只会产生一个Class对象
         */

        /**
         * 二，反射获取类构造方法，
         */

        //获取公有的构造函数
        Constructor<?>[] constructors = aClass3.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //获取所有的构造函数
        Constructor<?>[] declaredConstructors = aClass3.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        /**
         * 获取单个指定的构造方法
         */
        //获取无参的公共的构造方法
        try {
            Constructor<?> constructor = aClass3.getConstructor(null);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //获取参数类型是int的公共的构造方法,获取类并且实例化
        try {
            Constructor<?> constructor = aClass3.getConstructor(int.class);
            Object o = constructor.newInstance(1);
            ReflectTest o1 = (ReflectTest) o;
            System.out.println(o1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //获取私有的构造方法并调用
        try {
            Constructor<?> constructor = aClass3.getDeclaredConstructor(String.class);
            //不设置access会报错:Class src.reflect.Test can not access a member of class src.reflect.ReflectTest with modifiers "private
            constructor.setAccessible(true);
            Object o = constructor.newInstance("访问私有方法");
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        /**
         * 反射获取成员变量
         */
        //获取所有公有的成员变量
        Field[] fields = aClass3.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //获取所有的成员变量（公有，私有），但是不包含父类继承来的变量
        Field[] declaredFields = aClass3.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //获取单个私有的成员变量并暴力访问
        try {
            Field name = aClass3.getDeclaredField("name");
            name.setAccessible(true);
            //获取对象
//            Object o1 = aClass3.newInstance();
            ReflectTest o = (ReflectTest)aClass3.getConstructor().newInstance();
            name.set(o, "我叫张启磊");
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        /**
         * 获取成员方法
         */
        /**
         *  获取所有的 getMethods()->包括父类方法
         *  获取所有的 getDeclaredMethods() ->获取成员方法，包括私有的，不包含父类继承的
         */
        //获取单个成员方法并调用 --获取私有成员方法并调用
        try {
            Method getMyname = aClass3.getDeclaredMethod("getMyname", String.class);
            Method getMyAge = aClass3.getDeclaredMethod("getMyAge", int.class);
            //获取对象实例
            ReflectTest o = (ReflectTest)aClass3.newInstance();
            getMyAge.setAccessible(true);
            getMyname.invoke(o, "大哥");
            getMyAge.invoke(o,12);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
