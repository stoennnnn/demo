package src.jvm;

/**
 * 
 * ClassName：src.jvm.InternTest <br>
 * Description：不同版本的intern方法测试<br>
 * Copyright © 2019/6/17 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 26725 <br>
 * date 2019/6/17 16:16<br>
 * @version v1.0 <br>
 */
public class InternTest {
    public static void main(String[] args) {
        String s1 = new String("a");
        s1.intern();
        String s2="a";
        System.out.println(s1==s2);

        String s3=new String("a")+new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3==s4);
    }
}
