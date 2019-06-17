package src.proxy.cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import src.proxy.Person;

/**
 * Created by  @ZQL  on 2019/6/17.
 * cglib 的client
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        //设置代理类
        enhancer.setSuperclass(Person.class);
        //设置回调类
        enhancer.setCallback(cglibProxy);
        //create()方法生成代理对象
        Person person = (Person) enhancer.create();
        person.infomation();
    }
}
