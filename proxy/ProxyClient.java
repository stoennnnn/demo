package proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class ProxyClient {
    public static void main(String[] args) {
        Animal animal = new Cat();
        //生成代理对象
        Animal animal1 = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                animal.getClass().getInterfaces(),
                new ProxyHandler(animal));
        animal1.eat();
    }
}
