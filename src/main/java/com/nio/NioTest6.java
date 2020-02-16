package com.nio;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/1/31 9:23
 * @Version V1.0
 **/

/**
 * Slice Buffer与原有buffer共享相同的底层数组
 */

public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0;i<sliceBuffer.capacity();i++){
            byte b = sliceBuffer.get(i);
            b *=2;
            sliceBuffer.put(i,b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
