package proxy;

/**
 * Created by 张启磊 on 2019-6-4.
 */
public class CatProxy implements Animal {
    private Animal animal;

    public CatProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eat() {
        System.out.println("果冻");
        animal.eat();
        System.out.println("把猫粮吃完了");
    }
}
