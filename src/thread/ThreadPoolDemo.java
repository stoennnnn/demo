package src.thread;


import java.util.concurrent.*;

/**
 * Created by 26725 on 2019/4/28.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //不固定大小的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //固定线程数量
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        //单个线程的线程池
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //可定时和延迟执行的线程池
        Executors.newScheduledThreadPool(2);
        //计划的单个
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Future<String> submit = newCachedThreadPool.submit(new MyCallabel());

        if (submit.isDone()){
            System.out.println("task is waiting");
        }
        try {
            System.out.println("task return : "+submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            //关闭线程池
            newCachedThreadPool.shutdown();

    }
    }
}
