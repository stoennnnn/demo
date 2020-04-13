package src.reflect;import java.lang.reflect.*;import java.util.ArrayList;import java.util.Arrays;import java.util.List;/** * @Description: * @Date: 2020/4/9 17:21 * @Auther: zql */public class ReflectTest {    //成员变量    private int age;    private String name;    public double height;    //一个参数的构造    public ReflectTest(int age) {        this.age = age;    }    //二个参数的构造    public ReflectTest(int age, String name) {        this.age = age;        this.name = name;    }    //受保护的构造    protected ReflectTest(double height) {        this.height = height;    }    //私有的构造方法    private ReflectTest(String name) {        this.name = name;    }    //公共无参构造    public ReflectTest() {    }    //私有方法    private void getMyAge(int age) {        System.out.println("访问私有方法，年纪是:" + age);    }    public void getMyname(String name) {        System.out.println("访问公有方法，姓名是：" + name);    }    public  <T> List<Field> getAllDeclaredFields(T t) {        List<Field> fieldList = new ArrayList<>();        Class tempClass = t.getClass();        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己        }        return fieldList;    }}