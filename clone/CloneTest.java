package clone;

/**
 * Created by 26725 on 2018/12/11.
 */
public class CloneTest {
    public static void  main(String args[]) throws CloneNotSupportedException {
        Animal a1 = new Animal(new Dog());
        Animal a2 = (Animal) a1.clone();
        Animal a3 = a1;
        String result = a1==a3?"这是复制":"这是拷贝";
        String result2 = a1==a2?"这是复制":"这是拷贝";
        String result3 = a1.dog==a2.dog?"这是浅拷贝":"这是深拷贝";
        System.out.println(result);

    }
}
