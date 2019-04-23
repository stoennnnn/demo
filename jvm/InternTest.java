package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by 26725 on 2019/4/22.
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
