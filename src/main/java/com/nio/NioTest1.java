package com.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/1/30 9:33
 * @Version V1.0
 **/

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        System.out.println("capacity:"+buffer.capacity());

        for (int i = 0;i<5;++i){
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        System.out.println("before flip limit:"+buffer.limit());

        //两种模式切换的开关
        buffer.flip();

        System.out.println("after flip limit:"+buffer.limit());

        System.out.println("enter while loop");

        while (buffer.hasRemaining()){
            System.out.println("position:"+buffer.position());
            System.out.println("limit:"+buffer.limit());
            System.out.println("capacity:"+buffer.capacity());

            System.out.println(buffer.get());
        }
    }

}
