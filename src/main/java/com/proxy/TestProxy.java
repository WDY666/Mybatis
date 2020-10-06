package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author WDY
 * @Date 2020-09-27 17:16
 * @Description TODO
 */
public class TestProxy implements InvocationHandler {
    private Object object;

    public TestProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(object, args);
        System.out.println("after");
        return invoke;
    }
}
