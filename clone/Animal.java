package clone;

/**
 * Created by 26725 on 2018/12/11.
 */
public class Animal implements Cloneable{
    public Dog dog =new Dog();
    public String msg;

    public Animal(Dog dog){};
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal cloneAnimal = (Animal) super.clone();
       // cloneAnimal.dog = (Dog) dog.clone();
        return  cloneAnimal;
    }
}
