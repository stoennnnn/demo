package clone;

/**
 * Created by 26725 on 2018/12/11.
 */
public class Dog implements Cloneable{
    public   String name;
    public   int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
