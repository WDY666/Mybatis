package com.proxy;

/**
 * @Author WDY
 * @Date 2020-09-27 17:15
 * @Description TODO
 */
public class TestImpl implements Test{
    @Override
    public void add(int i, int j) {
        System.out.println(i+j);
    }
}
