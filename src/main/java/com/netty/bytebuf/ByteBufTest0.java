package com.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/2/11 1:03
 * @Version V1.0
 **/

public class ByteBufTest0 {

    public static void main(String[] args) {
        //创建一个长度未10的buffer对象
        ByteBuf byteBuf = Unpooled.buffer(10);
        for (int i = 0;i<10;i++){
            byteBuf.writeByte(i);
        }

        for (int i = 0;i<byteBuf.capacity();i++){
            System.out.println(byteBuf.getByte(i));
        }

    }
}
