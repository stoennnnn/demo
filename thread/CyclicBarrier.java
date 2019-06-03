package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by  @ZQL  on 2019/6/3.
 * CyclicBarrier的等待处理
 */
public class CyclicBarrier {
    public static void main(String[] args) throws Exception{
        java.util.concurrent.CyclicBarrier cb = new java.util.concurrent.CyclicBarrier(2);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"等待开始");
                    try {
                        int await = cb.await();
                        TimeUnit.SECONDS.sleep(await);
                        System.out.println(Thread.currentThread().getName()+"等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
