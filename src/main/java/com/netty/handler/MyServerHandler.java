package com.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/20 11:05
 * @Version V1.0
 **/

public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count ;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(msg);

        String message = new String(buffer, Charset.forName("utf-8"));

        System.out.println("����˽��յ�����Ϣ������:"+message);
        System.out.println("����˽��յ�����Ϣ������:"+(++this.count));

        ByteBuf responseByteBuf = Unpooled.copiedBuffer(UUID.randomUUID().toString(),Charset.forName("utf-8"));
        ctx.writeAndFlush(responseByteBuf);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause)throws Exception{
        cause.printStackTrace();
        ctx.close();
    }
}
