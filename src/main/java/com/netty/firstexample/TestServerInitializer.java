package com.netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/18 11:39
 * @Version V1.0
 **/

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    //�ܵ�����һ����ע��÷����ͻᱻ����
    //������Ӧ��handler
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());

    }
}
