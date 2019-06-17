package src.thread;

/**
 * Created by 26725 on 2019/4/28.
 */
public class SleepWaitDemo{
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A等待获得锁");
                synchronized (obj){
                    System.out.println("线程A得到了锁");
                    try {
                        //不传参数则无期限等待，并且释放锁
                         obj.wait(20);
                      //  Thread.sleep(100);
                        System.out.println("线程A执行结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //主线程等待上面的线程100s在执行
        try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B等待获得锁");
                //如果上面的线程不释放锁，那么这里的B无法获得obj的同步锁
                synchronized (obj){
                    System.out.println("线程B得到了锁");
                    try {
                        Thread.yield();
                        Thread.sleep(2000);
                        System.out.println("线程B执行结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
