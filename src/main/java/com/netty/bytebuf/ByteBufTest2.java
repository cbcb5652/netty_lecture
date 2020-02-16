package com.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.awt.*;
import java.util.Iterator;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/11 1:58
 * @Version V1.0
 **/

public class ByteBufTest2 {

    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(8);

        compositeByteBuf.addComponents(heapBuf,directBuf);
        compositeByteBuf.removeComponent(0);

        Iterator<ByteBuf> iter = compositeByteBuf.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        compositeByteBuf.forEach(System.out::println);
    }
}
