package com.netty.handler1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/2/16 17:39
 * @Version V1.0
 **/

public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyPersonEncoder encode invoked");

        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
