package com.netty.decorator;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/30 9:22
 * @Version V1.0
 **/

public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("¹¦ÄÜC");
    }

}