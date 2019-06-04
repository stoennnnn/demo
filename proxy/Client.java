package proxy;

/**
 * Created by 张启磊 on 2019-6-4.
 * 静态代理demo
 */
public class Client {
    public static void main(String[] args) {
        Animal animal = new Cat();
        CatProxy catProxy = new CatProxy(animal);
        catProxy.eat();

    }
}
