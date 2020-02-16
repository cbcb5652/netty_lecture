package com.nio;

import java.nio.ByteBuffer;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/1/31 9:32
 * @Version V1.0
 **/

/**
 * 只读buffer 我们可以随时将一个普通的buffer调用asReadOnlyBuffer方法返回一个只读buffer
 * 但不能将一个只读buffer转换为读写Buffer
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }
        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());

        readonlyBuffer.position(0);

        //readonlyBuffer调用put时直接抛出异常
//        readonlyBuffer.put((byte)2);
    }
}
