package com.netty.decorator;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/30 8:52
 * @Version V1.0
 **/

public class ConcreateDecorator1 extends Decorator {


    public ConcreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething(){
        super.doSomething();
        this.doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("¹¦ÄÜB");
    }

}
