package com.netty.decorator;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/30 8:50
 * @Version V1.0
 **/

public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
