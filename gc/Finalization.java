package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by 26725 on 2019/4/23.
 */
public class Finalization {
    public static Finalization finalization;
    //执行gc时调用
    @Override
    protected void finalize(){
        System.out.println("Finalized");
        finalization=this;
    }
    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("first: "+f);
        f = null;
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("second: "+f);
        System.out.println(f.finalization);
        String a = new String("a");
        SoftReference<String> softRef = new SoftReference<>(a);
        WeakReference<String> weakRef = new WeakReference<>(a);
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(a, referenceQueue);
    }
}
