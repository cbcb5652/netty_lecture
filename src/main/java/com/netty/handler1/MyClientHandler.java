package com.netty.handler1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import thrift.generated.Person;

import java.nio.charset.Charset;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/16 17:48
 * @Version V1.0
 **/

public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private  int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        for (int i = 0;i<10;i++){
            String messageToBaSent = "sent from client";
            byte[] content = messageToBaSent.getBytes(Charset.forName("utf-8"));
            int length = messageToBaSent.getBytes(Charset.forName("utf-8")).length;

            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setContent(content);
            personProtocol.setLength(length);

            ctx.writeAndFlush(personProtocol);

        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {

        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("�ͻ��˽��յ�����Ϣ:");

        System.out.println("����:"+length);
        System.out.println("����:"+new String(content,Charset.forName("utf-8")));

        System.out.println("�ͻ��˽��յ�����Ϣ������:"+(this.count++));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
