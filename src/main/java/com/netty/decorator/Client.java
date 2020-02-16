package com.netty.decorator;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/23 23:35
 * @Version V1.0
 **/

public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreateDecorator1(
                new ConcreateComponent()));
        component.doSomething();
    }
}
