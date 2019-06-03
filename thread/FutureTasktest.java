package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 26725 on 2019/4/28.
 */
public class FutureTasktest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask<String> task = new FutureTask<String>(new MyCallabel());
            Thread thread1 = new Thread(task);
            thread1.start();
        if (!task.isDone()){
            System.out.println("task is waiting");
        }
        System.out.println("task return : "+task.get());
    }
}
