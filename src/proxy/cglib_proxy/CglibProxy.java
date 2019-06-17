package src.proxy.cglib_proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import src.proxy.Person;

import java.lang.reflect.Method;

/**
 * cglib
 * return: 
 */
public class CglibProxy implements MethodInterceptor {
    /**
     * Title: intercept<br>
     * Author: 26725<br>
     * Description: (用一句话描述这个方法表示什么)<br>
     * Date:  16:06 <br>
     * @param o 被代理对象，委托对象
     * @param method 被拦截的方法
     * @param objects 参数
     * @param methodProxy 代理的方法
     * return: java.lang.Object
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理前");
        methodProxy.invokeSuper(o,objects);
        System.out.println("cglib代理后");
        return o;
    }
}
