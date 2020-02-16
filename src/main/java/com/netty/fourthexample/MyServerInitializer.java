package com.netty.fourthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author ≥ø±ﬂ#CB
 * @Date:created in  2020/1/20 11:02
 * @Version V1.0
 **/

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        //º‡Ã˝‘⁄“ª∂Œ ±º‰ƒ⁄”–√ª”–∂¡–¥¿¥≈–∂œ              ∂¡ø’œ–              –¥ø’œ–        ∂¡–¥ø’œ–
        pipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());



    }
}
