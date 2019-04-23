package reflect;

/**
 * Created by 26725 on 2019/4/18.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //static属性会在类初始化的时候加载
       // ClaclassLoaderss c  = Class.forName("reflect.Cat");  //输出：this is static method.
        ClassLoader  classLoader= Cat.class.getClassLoader();  //什么都没输出
    }
/*
  静态代码块
  static{
        System.out.print("this is static method.");
    }
*/
}
