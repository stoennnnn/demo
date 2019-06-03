package src;

import java.util.concurrent.Callable;

/**
 * Created by 26725 on 2019/5/5.
 */
public class ThreadLocalMap implements Runnable {
    public int flag = 1;
    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
//        if (flag == 0) {
//            synchronized (o2) {
//                try {
//                    Thread.sleep(500);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                synchronized (o1) {
//                    System.out.println("0");
//                }
//            }
//        }
    }

    public static void main(String[] args) {

        ThreadLocalMap td1 = new ThreadLocalMap();
        ThreadLocalMap td2 = new ThreadLocalMap();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();

    }
}
