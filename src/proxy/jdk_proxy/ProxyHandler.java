package src.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 张启磊 on 2019-6-4.
 * 动态代理类 demo
 */
public class ProxyHandler implements InvocationHandler {
    private Object target;
    public ProxyHandler ( Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //逻辑增强
        System.out.println("准备动态代理");
        //代理目标对象
        Object invoke = method.invoke(target, args);
        //逻辑增强
        System.out.println("动态代理结束");
        return invoke;
    }
}
