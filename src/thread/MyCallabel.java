package src.thread;

import java.util.concurrent.Callable;

/**
 * Created by 26725 on 2019/4/28.
 */
public class MyCallabel implements Callable<String>{
    private String name;
    @Override
    public String call() throws Exception {
        Thread.currentThread().sleep(3000);
        name = "zql";
        return name;
    }
}
