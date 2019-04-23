package jvm;

import java.io.IOException;
import java.util.Random;

/**
 * Created by 26725 on 2019/4/22.
 */
public class PermGenError {
    public static void main(String[] args) {
        for(int i=0; i <= 1000; i++){
            //将返回的随机字符串添加到字符串常量池中
            getRandomString(1000000).intern();
        }
        System.out.println("Mission Complete!");
    }

    //返回指定长度的随机字符串
    private static String getRandomString(int length) {
        //字符串源
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
