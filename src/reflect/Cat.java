package src.reflect;

/**
 * Created by 张启磊 on 2019-4-17.
 */
public class Cat {
    //猫的名字
    private String name;
    public void getName(){
        System.out.println("cat name is:"+name);
    }
    private String  sayHi(String value){
        return  "input value is："+value;
    }
    static{
        System.out.print("this is static method.");
    }
}
