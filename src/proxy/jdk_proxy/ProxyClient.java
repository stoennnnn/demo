package src.proxy.jdk_proxy;

import src.proxy.Animal;
import src.proxy.Cat;

import java.lang.reflect.Proxy;

/**
 * 动态代理demo
 */
public class ProxyClient {
    public static void main(String[] args) {
        Animal animal = new Cat();
        //生成代理对象
        Animal animal1 = (Animal) Proxy.newProxyInstance(
                Animal.class.getClassLoader(),
                animal.getClass().getInterfaces(),
                new ProxyHandler(animal));
        animal1.eat();
    }
}
