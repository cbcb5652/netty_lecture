package com.netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/1/18 11:39
 * @Version V1.0
 **/

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    //管道链接一旦被注册该方法就会被创建
    //关联对应的handler
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());

    }
}
