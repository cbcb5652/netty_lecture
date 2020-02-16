package com.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/11 1:03
 * @Version V1.0
 **/

public class ByteBufTest0 {

    public static void main(String[] args) {
        //����һ������δ10��buffer����
        ByteBuf byteBuf = Unpooled.buffer(10);
        for (int i = 0;i<10;i++){
            byteBuf.writeByte(i);
        }

        for (int i = 0;i<byteBuf.capacity();i++){
            System.out.println(byteBuf.getByte(i));
        }

    }
}
