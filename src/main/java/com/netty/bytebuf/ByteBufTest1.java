package com.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/2/11 1:29
 * @Version V1.0
 **/

public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", Charset.forName("utf-8"));
        //为true标识byteBuf为堆上缓冲
        if(byteBuf.hasArray()){
            byte[] content = byteBuf.array();
            System.out.println(new String(content,Charset.forName("utf-8")));
            System.out.println(byteBuf);

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());

            int length = byteBuf.readableBytes();

            System.out.println(length);

            for (int i = 0;i<byteBuf.readableBytes();i++){
                System.out.println((char)byteBuf.getByte(i));
            }

        }
    }
}
