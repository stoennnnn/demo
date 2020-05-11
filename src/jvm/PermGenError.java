package src.jvm;

import java.util.Random;

/**
 * 
 * ClassName：src.jvm.PermGenError <br>
 * Description：jvm中永久代存在检测<br>
 * @author 26725 <br>
 * date 2019/6/17 16:17<br>
 * @version v1.0 <br>
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
