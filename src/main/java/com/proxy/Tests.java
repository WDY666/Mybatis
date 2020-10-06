package com.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author WDY
 * @Date 2020-09-27 17:19
 * @Description TODO
 */
public class Tests {
    public static void main(String[] args) {
        Test o = (Test) Proxy.newProxyInstance(Tests.class.getClassLoader(), new Class[]{Test.class}, new TestProxy(new TestImpl()));
        o.add(1,2);
    }
}
