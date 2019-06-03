package thread;

import java.util.concurrent.*;

/**
 * Created by 26725 on 2019/4/28.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
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
