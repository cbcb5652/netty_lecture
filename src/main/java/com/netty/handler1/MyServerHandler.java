package com.netty.handler1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import thrift.generated.Person;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/16 17:41
 * @Version V1.0
 **/

public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int lenth = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("������յ�������:");
        System.out.println("����:"+lenth);
        System.out.println("����:"+new String(content, Charset.forName("utf-8")));

        System.out.println("����˽��յ�����Ϣ����:"+(++count));

        String resposeMessage = UUID.randomUUID().toString();
        int responseLength = resposeMessage.getBytes("utf-8").length;
        byte[] responseContent = resposeMessage.getBytes("utf-8");

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(responseLength);
        personProtocol.setContent(responseContent);

        ctx.writeAndFlush(personProtocol);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
