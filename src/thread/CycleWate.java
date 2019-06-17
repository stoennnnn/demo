package src.thread;

/**
 * Created by 26725 on 2019/4/28.
 */
public class CycleWate implements Runnable{
    private String name;
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "zql";
    }
    //主线程
    public static void main(String[] args) throws InterruptedException {
        CycleWate cw = new CycleWate();
        Thread thread1= new Thread(cw);
        thread1.start();
//        while (null==cw.name){
//            Thread.currentThread().sleep(1000);
//        }
        thread1.join();
        System.out.println(cw.name);
    }
}
